package com.example.mooc;
//应用功能讲解
//当输入数字1的时候,按下测试按钮,这个时候,模拟一个从网络上获取行程轨迹的过程.会出现进度条,当进度条到达百分之百的时候,会出现绿色的行程轨迹码
//当输入数字0,会出现黄色行程轨迹码

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class S0604_TripCode2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0604_trip_code2);

//        首先我们去拿到Intent
        Intent intent = getIntent();

//        获取数据，并存在一个字符串里
        String code = intent.getStringExtra("code");

//        将code显示在TextView上
        TextView textView = findViewById(R.id.textView2);
        textView.setText(code);

//        找到ImageView
        ImageView imageView = findViewById(R.id.imageView);
//        接着我们去显示行程码。如果是字符串1就显示绿码，否则就显示黄码
        if(code.equals("1")){
            imageView.setImageResource(R.drawable.ic_baseline_arrow_upward_green);
        } else {
            imageView.setImageResource(R.drawable.ic_baseline_arrow_upward_yellow);
        }
    }
}