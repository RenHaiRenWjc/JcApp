package com.wjc.jcapp.ui.login;

import android.os.Bundle;
import android.widget.TextView;

import com.wjc.jcapp.R;
import com.wjc.jcapp.bridge.MainLoginViewModel;
import com.wjc.jcapp.ui.base.BaseActivity;
import com.wjc.jcapp.ui.base.DataBindingConfig;

public class LoginActivity extends BaseActivity {

	private TextView mTextView;
	private MainLoginViewModel mMainLoginViewModel;

	@Override
	protected void initViewModel() {
//		mMainLoginViewModel = getActivityViewModel(MainLoginViewModel.class);

	}

	@Override
	protected DataBindingConfig getDataBindingConfig() {
		return new DataBindingConfig(R.layout.activity_login,null);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}