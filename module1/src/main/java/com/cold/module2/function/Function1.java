package com.cold.module2.function;

import android.app.Activity;
import android.widget.TextView;

import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Function1 {

    @BindView(R2.id.tv_test1)
    TextView tvTest1;

    public Function1(Activity activity) {
        ButterKnife.bind(this, activity.getWindow().getDecorView());
    }

    public void initView(){
        tvTest1.setText("hello1");
    }

}
