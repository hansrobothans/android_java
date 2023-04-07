package com.example.ttit.core.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.ttit.R;

import java.util.Timer;
import java.util.TimerTask;

public class P73_HandlerActivity extends AppCompatActivity {
    private int num = 0;
    private TextView tv;

    private Handler myHandler = new Handler() {
        @Override
        //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                num++;
                tv.setText(String.valueOf(num));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p73_handler);

        tv = findViewById(R.id.tv_content);
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        myHandler.sendEmptyMessage(0);
                    }
                }, 0, 1000);
            }
        });
    }
}