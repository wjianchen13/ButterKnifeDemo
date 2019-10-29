package com.cold.module2.inherited;

import android.app.Activity;
import android.widget.TextView;

import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InheritedModel2 extends CommonModule1 {

    @BindView(R2.id.tv_test2)
    TextView tvTest2;

    public InheritedModel2(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity.getWindow().getDecorView());
    }

    public void initView(){

        tvTest2.setText("hello2");
    }

}
