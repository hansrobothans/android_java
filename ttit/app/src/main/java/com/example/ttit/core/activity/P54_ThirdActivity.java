package com.example.ttit.core.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ttit.R;

public class P54_ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p54_third);

        Intent in = getIntent();
        //1.接收单个数据
        String val = in.getStringExtra("test");
        int val2 = in.getIntExtra("number", 0);
        Log.e("tag", "val =" + val);
        Log.e("tag", "val2 =" + val2);
//        //2.接收多个数据
//        Bundle b = in.getExtras();
//        String val3 = b.getString("test");
//        int val4 = b.getInt("number");
//        Log.e("tag", "val3 =" + val3);
//        Log.e("tag", "val4 =" + val4);


        Intent backIn = new Intent();
        backIn.putExtra("back", "abcdef");
        setResult(1002, backIn);
    }
}