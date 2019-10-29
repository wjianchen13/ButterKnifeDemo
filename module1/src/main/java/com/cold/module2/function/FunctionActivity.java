package com.cold.module2.function;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.cold.module2.module2.R;
import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FunctionActivity extends AppCompatActivity {

    /**
     * 绑定View
     */
    @BindView(R2.id.tv_test)
    TextView tvTest;

    private Function1 model1;
    private Function2 model2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        ButterKnife.bind(this);
        initView();
        model1 = new Function1(this);
        model1.initView();
        model2 = new Function2(this);
        model2.initView();
    }

    private void initView() {
        tvTest.setText("hello");
    }

    @OnClick(R2.id.btn_test1)
    public void showToast(){
        Toast.makeText(this, "点击事件测试", Toast.LENGTH_SHORT).show();
    }


}
