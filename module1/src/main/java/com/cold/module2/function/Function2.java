package com.cold.module2.function;

import android.app.Activity;
import android.widget.TextView;

import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Function2 {

    @BindView(R2.id.tv_test2)
    TextView tvTest2;

    public Function2(Activity activity) {
        ButterKnife.bind(this, activity.getWindow().getDecorView());
    }

    public void initView(){
        tvTest2.setText("hello2");
    }

}
