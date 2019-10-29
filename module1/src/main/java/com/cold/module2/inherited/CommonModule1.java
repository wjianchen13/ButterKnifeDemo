package com.cold.module2.inherited;

import android.app.Activity;
import android.widget.TextView;

import com.cold.base.BaseModule;
import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonModule1 extends BaseModule {

    @BindView(R2.id.tv_test2)
    protected TextView tvTest2;

    // 1.如果是不同模块，
    // 2.如果是同一个模块，

    public CommonModule1(Activity activity) {
        super(activity);
    }

    protected void bindSelf(Activity activity) {
        super.bindSelf(activity);
        // 只要是自己，就不用手动调用ViewBinding，但是如果同一个library，不同包需要有针对性处理，不需要调用
        if (!this.getClass().getName().contains("com.cold.module2.inherited")) {
            new CommonModule1_ViewBinding(this, activity.getWindow().getDecorView());
        }
    }

    public void initView(){
        tvTest2.setText("hello2");
        tvTest3.setText("hello3");
    }

}
