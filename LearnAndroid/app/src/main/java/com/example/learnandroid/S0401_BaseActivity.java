package com.example.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class S0401_BaseActivity extends AppCompatActivity {

//    把布局用到的控件都声明出来
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0401_base_activity);

//        通过findViewById找到对应的控件
        button = findViewById(R.id.button1);

//        设置按键的点击事件，来监听按键的点击
//        当按键按下的时候，从一个界面跳转到另一个界面
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                创建意图，从一个activity跳转都另一个activity
                Intent intent = new Intent(S0401_BaseActivity.this,S0401_BaseActivity2.class);
//                启动新的activity
//                一定，一定要在AndroidManifest声明新的activity
                startActivity(intent);

//                关闭第一个Activity,如果不关闭,第二个acitivity结束,这个activity会重新显示
//                finish();

            }
        });

    }
}