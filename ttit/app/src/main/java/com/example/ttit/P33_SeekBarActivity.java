package com.example.ttit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class P33_SeekBarActivity extends AppCompatActivity {
//    1. 声明控件
    private SeekBar sb_normal, sb_custom;
    private TextView txt_cur;
//    2.声明上下文变量
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p33_seek_bar);

//        3.获取上下文变量.也可以使用getApplicationContext()来获取
        mContext = this;

//        4.获取控件
        sb_normal = (SeekBar) findViewById(R.id.sb_normal);
        sb_custom = (SeekBar) findViewById(R.id.sb_custom);
        txt_cur = (TextView) findViewById(R.id.txt_cur);
//        5.设置监听事件
        sb_normal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            必须重写的三个方法
//            进度发生改变时会触发
//            第一个参数,当前的seekbar;第二个参数,当前进度值;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_cur.setText("当前进度值:" + progress + "  / 100 ");
            }
//            按住SeekBar时会触发
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(mContext, "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }
//            放开SeekBar时触发
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(mContext, "放开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });

//        6.设置二级进度值
        sb_custom.setSecondaryProgress(20);
    }
}