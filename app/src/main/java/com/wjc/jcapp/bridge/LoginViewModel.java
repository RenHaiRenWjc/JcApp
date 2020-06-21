package com.wjc.jcapp.bridge;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * ClassName: com.wjc.jcapp.bridge
 * Description:
 * JcChen on 2020.06.21.6:44 PM
 */
public class LoginViewModel extends ViewModel {
	public final ObservableField<String> name = new ObservableField<>();

	public final ObservableField<String> password = new ObservableField<>();

	public final ObservableBoolean loadingVisible = new ObservableBoolean();
}
