package com.example.myapplication;

import android.content.Intent;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class IntentJisuanqiActivity extends AppCompatActivity
{
    //声明对象
    EditText edita,editb;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_jisuanqi);
        //获取控件对象
        edita=(EditText)findViewById(R.id.edita);
        editb=(EditText)findViewById(R.id.editb);
        button=(Button)findViewById(R.id.button);

        //为控件绑定监听对象
        button.setOnClickListener(new Listener());
    }
    class Listener implements OnClickListener
    {
        public void onClick(View v)
        {
            Intent intent = new Intent();
            intent.putExtra("editastr",edita.getText().toString());
            intent.putExtra("editbstr",editb.getText().toString());
            intent.setClass(IntentJisuanqiActivity.this,IntentJisuanqiActivity2.class);
            startActivity(intent);

        }
    }
}