package com.cold.butterknifedemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cold.module2.R2;

import java.util.List;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class BaseActivity extends AppCompatActivity {

    /**
     * 绑定View
     */
    @BindView(R.id.tv_test1)
    TextView tvTest1;

    /**
     * 绑定多个View
     */
    @BindViews({R.id.tv_test2, R.id.tv_test3})
    public List<TextView> textList;

    /**
     * 绑定string
     */
    @BindString(R.string.base_bind_string)
    String str;

    /**
     * 绑定Bitmap
     */
    @BindBitmap(R.drawable.ic_launcher)
    public Bitmap mBitmap ;

    /**
     * 绑定颜色
     */
    @BindColor(R.color.base_bind_color)
    int color;
    
    @BindView(R.id.btn_test1)
    Button btnTest1;

    @BindView(R.id.imgv_bitmap)
    ImageView imgvBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base1);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTest1.setText(str);
        tvTest1.setTextColor(color);
        imgvBitmap.setImageBitmap(mBitmap);
        textList.get(0).setText("绑定多个View 1");
        textList.get(1).setText("绑定多个View 2");
    }

    @OnClick(R2.id.btn_test1)
    public void showToast(){
        Toast.makeText(this, "点击事件测试", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R2.id.btn_test1)
    public boolean showToastl(){
        Toast.makeText(this, "长按事件测试", Toast.LENGTH_SHORT).show();
        return true;
    }

}
