package com.cold.module2.inherited;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.cold.module2.module2.R;
import com.cold.module2.module2.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InheritedModelActivity extends AppCompatActivity {

    /**
     * 绑定View
     */
    @BindView(R2.id.tv_test)
    TextView tvTest;

    private CommonModule1 model1;
    private InheritedModel2 model2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_module);
        ButterKnife.bind(this);
        initView();
//        model1 = new CommonModule1(this);
//        model1.initView();
        model2 = new InheritedModel2(this);
        model2.initView();
    }

    private void initView() {
        tvTest.setText("hello");
    }
    

}
