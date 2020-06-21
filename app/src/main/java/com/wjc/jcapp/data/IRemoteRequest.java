package com.wjc.jcapp.data;

import androidx.lifecycle.MutableLiveData;

/**
 * ClassName: com.wjc.jcapp.data
 * Description:
 * JcChen on 2020.06.21.6:52 PM
 */
interface IRemoteRequest {
	void login(User user, MutableLiveData<String> liveData);

}
