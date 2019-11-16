package com.example.myapplication;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class SecondActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }
    public void onButtonClick(View V)
    {
        Intent intent=new Intent();
        intent.setClass(SecondActivity.this,FirstActivity.class);
        startActivity(intent);
        SecondActivity.this.finish();
    }

}
