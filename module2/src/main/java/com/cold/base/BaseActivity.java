package com.cold.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cold.module2.module2.R;
import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaseActivity extends AppCompatActivity {

    /**
     * 绑定View
     */
    @BindView(R2.id.tv_test1)
    TextView tvTest1;

    @BindView(R2.id.btn_test1)
    Button btnTest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base1);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTest1.setText("hello");
    }

    @OnClick(R2.id.btn_test1)
    public void showToast(){
        Toast.makeText(this, "点击事件测试", Toast.LENGTH_SHORT).show();
    }


}
