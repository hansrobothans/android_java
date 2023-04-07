package com.example.mooc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class S0404_HealthTag2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0404_health_tag2);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView3);
        TextView textView1 = findViewById(R.id.textView6);

        Intent intent = getIntent();
        boolean temp = intent.getBooleanExtra("temp",false);
        String name = intent.getStringExtra("name");
        String num = intent.getStringExtra("num");

        if (temp){
            imageView.setImageResource(R.drawable.ic_baseline_qr_code_2_green);
        }else {
            imageView.setImageResource(R.drawable.ic_baseline_qr_code_2_yellow);
        }

        textView.setText(name);
        textView1.setText(num);

    }
}