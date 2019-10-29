package com.cold.butterknifedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cold.module2.OtherActivity;
import com.cold.module2.function.FunctionActivity;
import com.cold.module2.temporary.AddViewActivity;
import com.cold.module2.fragment.FragmentTestActivity;
import com.cold.module2.dialogfragment.InheritedActivity;
import com.cold.module2.viewholder.RecyclerViewActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onBase(View v) {
        Intent it = new Intent();
        it.setClass(this, BaseActivity.class);
        startActivity(it);
    }

    public void onModule(View v) {
        Intent it = new Intent();
        it.setClass(this, OtherActivity.class);
        startActivity(it);
    }

    public void onFragment(View v) {
        Intent it = new Intent();
        it.setClass(this, FragmentTestActivity.class);
        startActivity(it);
    }

    @OnClick(R.id.btn_viewholder)
    public void onViewHolder() {
        Intent it = new Intent();
        it.setClass(this, RecyclerViewActivity.class);
        startActivity(it);
    }

    @OnClick(R.id.btn_addview)
    public void onAddView() {
        Intent it = new Intent();
        it.setClass(this, AddViewActivity.class);
        startActivity(it);
    }

    @OnClick(R.id.btn_inherited)
    public void onInherited() {
        Intent it = new Intent();
        it.setClass(this, InheritedActivity.class);
        startActivity(it);
    }

    @OnClick(R.id.btn_inherited_activity)
    public void onInheritedActivity() {
        Intent it = new Intent();
        it.setClass(this, com.cold.base.OtherActivity.class);
        startActivity(it);
    }

    @OnClick(R.id.btn_inherited_model)
    public void onInheritedModel() {
        Intent it = new Intent();
        it.setClass(this, com.cold.module2.inherited.InheritedModelActivity.class);
        startActivity(it);
    }


    @OnClick(R.id.btn_model)
    public void onModel() {
        Intent it = new Intent();
        it.setClass(this, FunctionActivity.class);
        startActivity(it);
    }

    @OnClick(R.id.btn_test_inherited_model)
    public void onTestInheritedModel() {
        Intent it = new Intent();
        it.setClass(this, TestInheritedModuleActivity.class);
        startActivity(it);
    }
}
