package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentJisuanqiActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_jisuanqi2);
        Intent intent=getIntent();
        int a,b,result;
        a=Integer.parseInt(intent.getStringExtra("editastr"));
        b=Integer.parseInt(intent.getStringExtra("editbstr"));
        result=a+b;
        TextView tv=(TextView)findViewById(R.id.tv);
        tv.setText(result+"");
    }
}