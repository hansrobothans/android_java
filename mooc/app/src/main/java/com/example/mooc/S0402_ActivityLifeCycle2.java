package com.example.mooc;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class S0402_ActivityLifeCycle2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0402_life_cycle2);

        Log.e("Lifecycle","S0402_ActivityLifeCycle2:onCreate被调用");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Lifecycle","S0402_ActivityLifeCycle2:onStart被调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Lifecycle","S0402_ActivityLifeCycle2:onResume被调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Lifecycle","S0402_ActivityLifeCycle2:onPause被调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Lifecycle","S0402_ActivityLifeCycle2:onStop被调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Lifecycle","S0402_ActivityLifeCycle2:onDestroy被调用");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Lifecycle","S0402_ActivityLifeCycle2:onRestart被调用");
    }
}