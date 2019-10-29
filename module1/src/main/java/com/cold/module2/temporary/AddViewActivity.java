package com.cold.module2.temporary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cold.module2.R;
import com.cold.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddViewActivity extends AppCompatActivity {

    @BindView(R2.id.tv_test1)
    TextView tvTest1;

    @BindView(R2.id.llyt_frame)
    LinearLayout llytFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addview);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(this).inflate(R.layout.item_addview, null);
        ViewHolder viewHolder = new ViewHolder(view);
        llytFrame.addView(view);
        viewHolder.tv_item.setText("我是改变后的文字");
    }

    class ViewHolder {

        @BindView(R2.id.tv_item)
        TextView tv_item;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
