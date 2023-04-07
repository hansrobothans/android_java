package com.example.mooc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class S0402_ActivityLifeCycle extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0402_life_cycle);

        Log.d("Lifecycle","S0402_ActivityLifeCycle:onCreate被调用");

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(S0402_ActivityLifeCycle.this,S0402_ActivityLifeCycle2.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","S0402_ActivityLifeCycle:onStart被调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","S0402_ActivityLifeCycle:onResume被调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","S0402_ActivityLifeCycle:onPause被调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","S0402_ActivityLifeCycle:onStop被调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle","S0402_ActivityLifeCycle:onDestroy被调用");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle","S0402_ActivityLifeCycle:onRestart被调用");
    }
}