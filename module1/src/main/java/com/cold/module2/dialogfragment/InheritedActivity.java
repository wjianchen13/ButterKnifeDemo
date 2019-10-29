package com.cold.module2.dialogfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cold.module2.R;
import com.cold.module2.R2;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InheritedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inherited);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btn_show_dialog)
    public void onInherited() {
        MyDialogFragment editNameDialog = new MyDialogFragment();
        editNameDialog.show(getSupportFragmentManager(), "EditNameDialog");
    }


}
