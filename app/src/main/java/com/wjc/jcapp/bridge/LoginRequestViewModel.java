package com.wjc.jcapp.bridge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wjc.jcapp.data.DataRepository;
import com.wjc.jcapp.data.User;

/**
 * ClassName: com.wjc.jcapp.bridge
 * Description:
 * JcChen on 2020.06.21.6:45 PM
 */
public class LoginRequestViewModel extends ViewModel {
	private MutableLiveData<String> tokenLiveData;

	public LiveData<String> getTokenLiveData() {
		if (tokenLiveData == null) {
			tokenLiveData = new MutableLiveData<>();
		}
		return tokenLiveData;
	}

	public void requestLogin(User user) {// user相当于请求体
		DataRepository.getInstance().login(user, tokenLiveData);
	}
}
