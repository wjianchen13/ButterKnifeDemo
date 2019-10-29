package com.cold.module2.dialogfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseDialogFragment extends DialogFragment {

	protected Activity mContext;
	private Unbinder unbinder;

	private View view;

	public View onCreateViewEx(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
		return null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = onCreateViewEx(inflater, container, savedInstanceState);
		try {
			unbinder = ButterKnife.bind(this, view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mContext = getActivity();
	}

	/**
	 * Fragment本身正在销毁视图，回收资源
	 */
	@Override
	public void onDestroyView() {
		try {
			super.onDestroyView();
			if (unbinder != null) {
				unbinder.unbind();
				unbinder = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
