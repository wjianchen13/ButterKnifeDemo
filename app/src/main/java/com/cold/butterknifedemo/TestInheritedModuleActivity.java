package com.cold.butterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cold.module2.module2.R;
import com.cold.module2.module2.R2;
import com.cold.module2.inherited.CommonModule1;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestInheritedModuleActivity extends AppCompatActivity {

    /**
     * 绑定View
     */
    @BindView(R2.id.tv_test)
    TextView tvTest;

    private CommonModule1 model2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module);
        ButterKnife.bind(this);
        initView();
        model2 = new CommonModule1(this);
        model2.initView();
    }

    private void initView() {
        tvTest.setText("hello");
    }

}
