package com.wjc.jcapp.ui.base;

import android.util.SparseArray;

import androidx.lifecycle.ViewModel;

/**
 * ClassName: com.wjc.jcapp.ui.base
 * Description:
 * JcChen on 2020.06.21.4:22 PM
 */
public class DataBindingConfig {
	private int layout;

	private ViewModel stateViewModel;

	private SparseArray bindingParams = new SparseArray();

	public DataBindingConfig(int layout, ViewModel stateViewModel) {
		this.layout = layout;
		this.stateViewModel = stateViewModel;
	}

	public int getLayout() {
		return layout;
	}

	public ViewModel getStateViewModel() {
		return stateViewModel;
	}

	public SparseArray getBindingParams() {
		return bindingParams;
	}

	public DataBindingConfig addBindingParam(int variableId, Object object) {
		if (bindingParams.get(variableId) == null) {
			bindingParams.put(variableId, object);
		}
		return this;
	}
}
