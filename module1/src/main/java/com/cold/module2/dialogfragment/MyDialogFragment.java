package com.cold.module2.dialogfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cold.module2.R;
import com.cold.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDialogFragment extends AbsDialogFragment {

	private View mView;

	@Override
	public void initView(LinearLayout parent) {
		mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_fragment_my, null);
		parent.addView(mView);
		ViewHolder viewHolder = new ViewHolder(mView);
		viewHolder.tvTest1.setText("test1");
		viewHolder.tvTest2.setText("test2");
	}

	class ViewHolder {

		@BindView(R2.id.tv_test1)
		TextView tvTest1;

		@BindView(R2.id.tv_test2)
		TextView tvTest2;

		public ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
