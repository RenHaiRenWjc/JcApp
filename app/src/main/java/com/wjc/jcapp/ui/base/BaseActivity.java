package com.wjc.jcapp.ui.base;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wjc.jcapp.App;
import com.wjc.jcapp.BR;
import com.wjc.jcapp.ui.base.DataBindingConfig;

/**
 * ClassName: com.wjc.jcapp.ui
 * Description:
 * JcChen on 2020.06.21.3:50 PM
 */
public abstract class BaseActivity extends AppCompatActivity {
	private static final String TAG = "BaseActivity";
	private ViewModelProvider mActivityProvider;
	private ViewDataBinding mBinding;

	protected abstract void initViewModel();

	protected abstract DataBindingConfig getDataBindingConfig();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initViewModel();
		DataBindingConfig dataBindingConfig = getDataBindingConfig();

		//TODO tip: DataBinding 严格模式：
		// 将 DataBinding 实例限制于 base 页面中，默认不向子类暴露，
		// 通过这样的方式，来彻底解决 视图调用的一致性问题，
		// 如此，视图刷新的安全性将和基于函数式编程的 Jetpack Compose 持平。

		// 如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350 和 https://xiaozhuanlan.com/topic/2356748910

		ViewDataBinding binding = DataBindingUtil.setContentView(this, dataBindingConfig.getLayout());
		Log.i(TAG, ": binding=="+binding+",layout="+dataBindingConfig.getLayout());
		binding.setLifecycleOwner(this);
//		binding.setVariable(BR.vm, dataBindingConfig.getStateViewModel());
		SparseArray bindingParams = dataBindingConfig.getBindingParams();
		for (int i = 0, length = bindingParams.size(); i < length; i++) {
			binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
		}
		mBinding = binding;
	}

	protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
		if (mActivityProvider == null) {
			mActivityProvider = new ViewModelProvider(this);
		}
		return mActivityProvider.get(modelClass);
	}

}
