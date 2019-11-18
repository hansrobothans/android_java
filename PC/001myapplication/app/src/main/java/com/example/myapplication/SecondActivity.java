package com.example.myapplication;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.View;

public class SecondActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }
//    新建一个函数，处理点击事件，函数名应该与Android：onClick的值相同
    public void onButtonClick(View V)
    {
//        建立一个intent实例
        Intent intent=new Intent();
//        调用刚才新建的inten实例中的setclass函数进行跳转页面。要传递两个参数，第一个是当前的activity页面，第二个是要跳转到的activity
        intent.setClass(SecondActivity.this,FirstActivity.class);
//        开始第二个activity
        startActivity(intent);
//        结束当前activity
        SecondActivity.this.finish();
    }

}
