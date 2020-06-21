package com.wjc.jcapp;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/**
 * ClassName: com.wjc.jcapp
 * Description:
 * JcChen on 2020.06.21.3:55 PM
 */
public class App extends Application implements ViewModelStoreOwner {


	private ViewModelStore mAppViewModelStore;
	private ViewModelProvider.AndroidViewModelFactory mFactory;

	@Override
	public void onCreate() {
		super.onCreate();
		mAppViewModelStore = new ViewModelStore();
	}

	@NonNull
	@Override
	public ViewModelStore getViewModelStore() {
		return mAppViewModelStore;
	}

	public ViewModelProvider getAppViewModelProvider(Activity activity) {
		return new ViewModelProvider((App) activity.getApplicationContext(),
			((App) activity.getApplicationContext()).getAppFactory(activity));
	}

	private ViewModelProvider.Factory getAppFactory(Activity activity) {
		Application application = checkApplication(activity);
		if (mFactory == null) {
			mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
		}
		return mFactory;
	}

	private Application checkApplication(Activity activity) {
		Application application = activity.getApplication();
		if (application == null) {
			throw new IllegalStateException("Your activity/fragment is not yet attached to "
				+ "Application. You can't request ViewModel before onCreate call.");
		}
		return application;
	}
}
