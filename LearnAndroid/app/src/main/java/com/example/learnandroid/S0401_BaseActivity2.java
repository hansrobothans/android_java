package com.example.learnandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class S0401_BaseActivity2 extends AppCompatActivity {

//    把布局用到的控件都声明出来
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0401_base_activity2);

//        通过findViewById找到对应的控件
        button2 = findViewById(R.id.button2);

//        设置按键的点击事件，来监听按键的点击
//        当按键按下的时候，结束activity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}