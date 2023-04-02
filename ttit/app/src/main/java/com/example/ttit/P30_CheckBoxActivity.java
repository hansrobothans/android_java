package com.example.ttit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class P30_CheckBoxActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
//    1.声明控件
    private CheckBox cb_one;
    private CheckBox cb_two;
    private CheckBox cb_three;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p30_check_box);

//        2.获取控件
        cb_one = (CheckBox) findViewById(R.id.cb_one);
        cb_two = (CheckBox) findViewById(R.id.cb_two);
        cb_three = (CheckBox) findViewById(R.id.cb_three);
        btn_send = (Button) findViewById(R.id.btn_send);

//        5.注册监听事件.
//        需要实现接口CompoundButton.OnCheckedChangeListener
        cb_one.setOnCheckedChangeListener(this);
        cb_two.setOnCheckedChangeListener(this);
        cb_three.setOnCheckedChangeListener(this);
//        需要实现接口View.OnClickListener
        btn_send.setOnClickListener(this);
    }

//    3.重写check监听事件
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        获取改变状态控件文本
        String s = compoundButton.getText().toString().trim();
//        如果是勾选
        if (compoundButton.isChecked()) {
            Toast.makeText(this, compoundButton.getText().toString().trim(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, compoundButton.getText().toString().trim()+"取消勾选", Toast.LENGTH_SHORT).show();
        }
    }
//    4.重写按钮点击监听事件
    @Override
    public void onClick(View view) {
        String choose = "";
        if (cb_one.isChecked()) choose += cb_one.getText().toString() + "";
        if (cb_two.isChecked()) choose += cb_two.getText().toString() + "";
        if (cb_three.isChecked()) choose += cb_three.getText().toString() + "";
        Toast.makeText(this, choose, Toast.LENGTH_SHORT).show();
    }
}