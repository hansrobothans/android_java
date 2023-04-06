package com.example.ttit.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.example.ttit.R;

public class P32_ProgressBarActivity extends AppCompatActivity {
//    1.定义变量,当前进度值和最大进度值
    private int currentProgress = 0;//当前进度值
    private int maxProgress; //最大进度值
//    2.声明控件
    private ProgressBar progressBar;

//    5.进度值是在子线程处理，而进度条是在主线程里更新
//    新建进程变量
    private Handler mHandler = new Handler() {
//        使用handleMessage来处理消息事,处理子线程发过来的消息
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
//            switch (msg.what) {
//                case 0:
////                    根据子线程发送过来的信息,更新进度条
//                    progressBar.setProgress(currentProgress);
//                    break;
//            }
//            此处与教程不同,采用消息处理机制
            progressBar.setProgress(msg.arg1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p32_progress_bar);
//        3.获取控件
        progressBar = findViewById(R.id.pb);
//        4.获取进度条最大值
        maxProgress = progressBar.getMax();
    }

//    6.重写start方法
    @Override
    protected void onStart() {
        super.onStart();
//        因为progressbar操作比较耗时，所以我们要放到另一个线程来。首先我们要让他的进度来更新
//        启动线程模拟加载
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
//                        从0到一百
                        for (int i = 0; i <= maxProgress; i++) {
//                            为了看到这个效果，我们要给这个程序加个延时。
                            Thread.sleep(1000);
//                            进度增加
                            currentProgress += 10;
//                            到达最大进度值,停止循环
                            if (currentProgress > maxProgress) {
                                break;
                            }

//                            mHandler.sendEmptyMessage(0);
//                            此处也与教程不同,采用消息发送机制

//                            获取handler的消息
                            Message msg =  mHandler.obtainMessage();
//                            获取到消息,将消息放点内容.第一个参数,将进度放进去
                            msg.arg1 = currentProgress;
//                            进度放进去之后,我们要将这个消息发布出去
                            mHandler.sendMessage(msg);


                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}