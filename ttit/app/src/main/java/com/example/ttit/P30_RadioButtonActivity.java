package com.example.ttit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class P30_RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p30_radio_button);
//        1.获取控件对象
        Button btnchange = (Button) findViewById(R.id.btnpost);
        final RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);

//        第一种获得单选按钮值的方法为radioGroup设置一个监听器:setOnCheckedChanged()
//        监测单选按钮是否被点击，当点击勾选按钮时候输出提示信息
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "你选了:  " + radbtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });

//        第二种为radioGroup设置一个监听器:setOnCheckedChanged()
//        监视提交按钮，当点击提交的按钮时候输出提示信息
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getChildCount获取radgroup中包含的radiobutton的个数
                for (int i = 0; i < radgroup.getChildCount(); i++) {
//                    通过getChildAt方法加下标获得radiobutton对象
                    RadioButton rd = (RadioButton) radgroup.getChildAt(i);
//                    再判断是否被选中，如果被选中就会弹出一个提示
                    if (rd.isChecked()) {
                        Toast.makeText(getApplicationContext(), "你选择的是:  " + rd.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });
    }
}