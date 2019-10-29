package com.cold.butterknifedemo;

import android.app.Activity;
import android.widget.TextView;

import com.cold.module2.module2.R2;
import com.cold.module2.inherited.CommonModule1;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestModule extends CommonModule1 {

    @BindView(R2.id.tv_test1)
    TextView tvTest1;

    public TestModule(Activity activity) {
        super(activity);
    }

    public void initView(){
        tvTest1.setText("hello1");
        tvTest2.setText("hello2");
        tvTest3.setText("hello3");
    }

}
