package com.cold.base;

import android.app.Activity;
import android.widget.TextView;

import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseModule {

    @BindView(R2.id.tv_test3)
    protected TextView tvTest3;

    // 1.如果是不同模块，
    // 2.如果是同一个模块，

    public BaseModule(Activity activity) {
        ButterKnife.bind(this, activity.getWindow().getDecorView());
        bindSelf(activity);

//          com.cold.butterknifedemo.TestInheritedModel
//        if (!this.getClass().getName().contains("YOUR_MIAN_PACKETNAME_OF_MODULE")) { // 这个方式不好，因为不知道有多少个Superclass
//            ButterKnife.bind(this.getClass().getSuperclass(), activity.getWindow().getDecorView());
//        }
    }

    protected void bindSelf(Activity activity) {
        if (!this.getClass().getName().contains("com.cold.base")) {
            new BaseModule_ViewBinding(this, activity.getWindow().getDecorView());
        }
    }

    public void initView(){
        tvTest3.setText("hello1");
    }

}
