package com.example.myapplication;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class FirstActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
    }
    public void onButtonClick1(View V)
    {
        Intent intent=new Intent();
        intent.setClass(FirstActivity.this,SecondActivity.class);
        startActivity(intent);
        FirstActivity.this.finish();
    }

}
