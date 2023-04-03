package com.example.ttit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

//1.实现接口
public class P35_ChronometerActivity extends AppCompatActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {
//    2.声明控件
    private Button btn_start, btn_stop, btn_base, btn_format;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p35_chronometer);

//        7.调用初始化控件方法，初始化控件
        initView();
//        8.运行
    }
//    3.定义初始化控件方法
    private void initView() {
//        4.绑定控件
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        btn_start = (Button) findViewById(R.id.btnStart);
        btn_stop = (Button) findViewById(R.id.btnStop);
        btn_base = (Button) findViewById(R.id.btnReset);
        btn_format = (Button) findViewById(R.id.btn_format);

        chronometer.setOnChronometerTickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_base.setOnClickListener(this);
        btn_format.setOnClickListener(this);

    }

//    5.重写按钮点击方法
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                chronometer.start();// 开始计时
                break;
            case R.id.btnStop:
                chronometer.stop();// 停止计时
                break;
            case R.id.btnReset:
                chronometer.setBase(SystemClock.elapsedRealtime());// 复位
                break;
            case R.id.btn_format:
                chronometer.setFormat("Time：%s");// 更改时间显示格式
                break;
        }
    }

//    6.重写计时器时间到了事件方法
    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if (time.equals("00:00")) {
            Toast.makeText(this, "时间到了~", Toast.LENGTH_SHORT).show();
        }
    }
}