package com.wjc.jcapp.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjc.jcapp.BR;
import com.wjc.jcapp.R;
import com.wjc.jcapp.bridge.LoginRequestViewModel;
import com.wjc.jcapp.bridge.LoginViewModel;
import com.wjc.jcapp.ui.base.BaseFragment;
import com.wjc.jcapp.ui.base.DataBindingConfig;

/**
 * create an instance of this fragment.
 *
 */
public class MainLoginFragment extends BaseFragment {

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
//        getLifecycle().addObserver(DrawerCoordinateHelper.getInstance());
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_main_login, null)
            .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mAccountRequestViewModel.getTokenLiveData().observe(getViewLifecycleOwner(), s -> {
//            mLoginViewModel.loadingVisible.set(false);
//            nav().navigateUp();
//        });
    }

    public class ClickProxy {

        public void login() {
            nav().navigate(R.id.loginPwdFragment);
        }

        public void register() {
            nav().navigate(R.id.registerFragment);
        }

    }
}