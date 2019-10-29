package com.cold.module2.dialogfragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cold.module2.R;
import com.cold.module2.R2;

import butterknife.BindView;

public abstract class AbsDialogFragment extends BaseDialogFragment {

	@BindView(R2.id.tv_title)
	TextView tvTitle;

	@BindView(R2.id.llyt_frame)
	LinearLayout llytFrame;

	public abstract void initView(LinearLayout parent);

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
		if (getDialog() != null && getDialog().getWindow() != null) {
			Window window = getDialog().getWindow();
			WindowManager.LayoutParams params = window.getAttributes();
			window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			window.getDecorView().setPadding(0, 0, 0, 0); //消除边距
			window.setAttributes(params);
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
	}

	public void initView() {
		tvTitle.setText("继承测试");
		initView(llytFrame);
	}

	@Override
	public View onCreateViewEx(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		getDialog().setCanceledOnTouchOutside(true);
		return inflater.inflate(R.layout.dialog_fragment_base, container, false);
	}


}
