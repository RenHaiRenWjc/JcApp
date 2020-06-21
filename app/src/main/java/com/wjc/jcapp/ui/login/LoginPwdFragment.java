package com.wjc.jcapp.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjc.jcapp.BR;
import com.wjc.jcapp.R;
import com.wjc.jcapp.bridge.LoginRequestViewModel;
import com.wjc.jcapp.bridge.LoginViewModel;
import com.wjc.jcapp.data.User;
import com.wjc.jcapp.ui.base.BaseFragment;
import com.wjc.jcapp.ui.base.DataBindingConfig;

/**
 * create an instance of this fragment.
 */
public class LoginPwdFragment extends BaseFragment {
	private LoginViewModel mLoginViewModel;
	private LoginRequestViewModel mAccountRequestViewModel;

	@Override
	protected void initViewModel() {
		mLoginViewModel = getFragmentViewModel(LoginViewModel.class);
		mAccountRequestViewModel = getFragmentViewModel(LoginRequestViewModel.class);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected DataBindingConfig getDataBindingConfig() {
		return new DataBindingConfig(R.layout.fragment_login_pwd, mLoginViewModel)
			.addBindingParam(BR.click, new ClickProxy());
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
        mAccountRequestViewModel.getTokenLiveData().observe(getViewLifecycleOwner(), s -> {
            mLoginViewModel.loadingVisible.set(false);
//            nav().navigateUp();
			getActivity().finish();
        });
	}

	public class ClickProxy {

		public void back() {
			nav().navigateUp();
		}

		public void login() {
			if (TextUtils.isEmpty(mLoginViewModel.name.get()) || TextUtils.isEmpty(mLoginViewModel.password.get())) {
				showLongToast("用户名或密码不完整");
				return;
			}
			User user = new User(mLoginViewModel.name.get(), mLoginViewModel.password.get());
			mAccountRequestViewModel.requestLogin(user);
			mLoginViewModel.loadingVisible.set(true);
		}

	}
}