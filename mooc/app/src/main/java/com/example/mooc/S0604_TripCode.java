package com.example.mooc;
//应用功能讲解
//当输入数字1的时候,按下测试按钮,这个时候,模拟一个从网络上获取行程轨迹的过程.会出现进度条,当进度条到达百分之百的时候,会出现绿色的行程轨迹码
//当输入数字0,会出现黄色行程轨迹码

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class S0604_TripCode extends AppCompatActivity {
//    定义用到的控件
    private TextView textView;
    private ProgressBar progressBar;
    private EditText editText;
    private Button button;
//    要做进度更新，首先要有个进度值
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0604_trip_code);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);

//        接下来要写一个进程,来模拟从网路上来获取行程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                模拟网络加载数据的过程
                while(progress < 100){
//                    不停的循环，加加
                    progress++;

//                    使用runOnUiThread更新UI控件
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //UI控件更新
                            textView.setText(progress + "%");
                        }
                    });

//                    为了看到这个效果，我们要给这个程序加个延时。处理一下这个异常。
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                进度走完跳转
                Intent intent = new Intent(S0604_TripCode.this,S0604_TripCode2.class);
//                然后我们还需要传个数据过去,获取editText的数据,转成字符串,并去掉空格
                intent.putExtra("code",editText.getText().toString().trim());
//                启动新的activity前复位所有状态
                progress = 0;
                progressBar.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
//                启动新的activity
                startActivity(intent);
            }
        };

//        我们runnable new出来了,我们还需要启动它.我们想在button的点击事件里面启动它
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                首先需要一个进程,传入我们写好的runnable
                Thread thread = new Thread(runnable);
//                启动进程
                thread.start();
//                进程启动的同时,让progressBar变得可见
                progressBar.setVisibility(View.VISIBLE);
//                进程启动的同时,让textView变得可见
                textView.setVisibility(View.VISIBLE);
            }
        });

    }
}