package com.wjc.jcapp.data;

import androidx.lifecycle.MutableLiveData;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ClassName: com.wjc.jcapp.data
 * Description:
 * JcChen on 2020.06.21.6:51 PM
 */
public class DataRepository implements IRemoteRequest {
	private static final DataRepository ourInstance = new DataRepository();

	public static DataRepository getInstance() {
		return ourInstance;
	}

	private DataRepository() {
	}

	/**
	 * TODO 模拟登录的网络请求
	 *
	 * @param user     ui 层填写的用户信息
	 * @param liveData 模拟网络请求返回的 token
	 */
	@Override
	public void login(User user, MutableLiveData<String> liveData) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {

				//TODO 模拟登录，假装花费了 2000 毫秒去提交用户信息，结果遭遇网络状况不良。
				//这时候可以通过 NetworkState 去通知 UI 层做出变化。

//				NetState netState = new NetState();
//				netState.setSuccess(false);
//				netState.setResponseCode("404");
//
//				if (netState.isSuccess()) {
//					//TODO 否则，网络状况好的情况下，可向 UI 层回传来自网络请求响应的 token 等其他信息
//					liveData.postValue("token:xxxxxxxxxxxx");
//				}
				liveData.postValue("token:xxxxxxxxxxxx");
			}
		};

		timer.schedule(task, 2000);
	}

}
