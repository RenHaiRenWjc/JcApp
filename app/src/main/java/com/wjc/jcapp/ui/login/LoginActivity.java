package com.wjc.jcapp.ui.login;

import android.os.Bundle;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.wjc.jcapp.R;
import com.wjc.jcapp.bridge.MainActivityViewModel;
import com.wjc.jcapp.ui.base.BaseActivity;
import com.wjc.jcapp.ui.base.DataBindingConfig;

public class LoginActivity extends BaseActivity {

	private TextView mTextView;
	private MainActivityViewModel mMainActivityViewModel;

	@Override
	protected void initViewModel() {
		mMainActivityViewModel = getActivityViewModel(MainActivityViewModel.class);

	}

	@Override
	protected DataBindingConfig getDataBindingConfig() {
		return new DataBindingConfig(R.layout.activity_login, mMainActivityViewModel);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}