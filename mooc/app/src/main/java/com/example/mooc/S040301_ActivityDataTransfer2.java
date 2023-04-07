package com.example.mooc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class S040301_ActivityDataTransfer2 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s040301_data_transfer2);
        Intent intent = getIntent();

        //使用getExtra接收数据
        String name = intent.getStringExtra("name");
        int score = intent.getIntExtra("score", 0);

        //使用Bundle接收数据
//        Bundle bundle = intent.getExtras();
//        String name = bundle.getString("name");
//        int score = bundle.getInt("score",0);

        textView = findViewById(R.id.textView);
        textView.setText("name=" + name + ",score=" + score);
    }
}