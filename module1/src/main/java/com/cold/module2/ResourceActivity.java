package com.cold.module2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResourceActivity extends AppCompatActivity {

    @BindView(R2.id.tv_test1)
    TextView tvTest1;

    @BindView(R2.id.btn_test1)
    Button btnTest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        ButterKnife.bind(this);
        tvTest1.setText("ButterKnife");


    }
}
