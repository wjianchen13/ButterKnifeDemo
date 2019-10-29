package com.cold.base;

import android.os.Bundle;
import android.widget.TextView;

import com.cold.module2.module2.R;
import com.cold.module2.module2.R2;

import butterknife.BindView;

public class OtherActivity extends BaseActivity {

    /**
     * 绑定View
     */
    @BindView(R2.id.tv_test2)
    TextView tvTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base1);
//        ButterKnife.bind(this);
        tvTest2 = findViewById(R.id.tv_test2);
        initView();
    }

    private void initView() {
        tvTest2.setText("hello3");
    }


}
