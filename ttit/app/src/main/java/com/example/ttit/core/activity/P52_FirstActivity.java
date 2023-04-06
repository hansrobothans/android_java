package com.example.ttit.core.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ttit.R;

public class P52_FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onCreate() ===");
        setContentView(R.layout.activity_p52_first);

        Button btn = findViewById(R.id.btn_first_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示启动
                Intent in = new Intent(P52_FirstActivity.this, P52_SecondActivity.class);
                startActivity(in);
//                //隐式启动
//                Intent in = new Intent("com.example.ttit.core.activity.P52_SecondActivity");
//                startActivity(in);
            }
        });

        Button btn2 = findViewById(R.id.btn_first_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(P52_FirstActivity.this, P54_ThirdActivity.class);
                //1.传单个数据
                in.putExtra("test","TTIT");
                in.putExtra("number",100);
//                //2.传多个数据
//                Bundle b = new Bundle();
//                b.putInt("number", 100);
//                b.putString("test", "TTIT");
//                in.putExtras(b);

//                启动Activity
                startActivity(in);

                //返回数据给FirstActivity
//                startActivityForResult(in, 1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("tag", "requestCode =" + requestCode);
        Log.e("tag", "resultCode =" + resultCode);
        Log.e("tag", "data =" + data.getStringExtra("back"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onStart() ===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onResume() ===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onPause() ===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onStop() ===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onRestart() ===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onDestroy() ===");
    }
}