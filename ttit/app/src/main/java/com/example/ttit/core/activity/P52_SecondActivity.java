package com.example.ttit.core.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.ttit.R;

public class P52_SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ttit", "执行生命周期函数:=== SecondActivity: onCreate() ===");
        setContentView(R.layout.activity_p52_second);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ttit", "执行生命周期函数:=== SecondActivity: onStart() ===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ttit", "执行生命周期函数:=== SecondActivity: onResume() ===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ttit", "执行生命周期函数:=== SecondActivity: onPause() ===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ttit", "执行生命周期函数:=== SecondActivity: onStop() ===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("ttit", "执行生命周期函数:=== SecondActivity: onRestart() ===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ttit", "执行生命周期函数:=== SecondActivity: onDestroy() ===");
    }
}