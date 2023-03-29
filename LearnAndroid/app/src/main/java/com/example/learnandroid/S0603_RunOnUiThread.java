package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class S0603_RunOnUiThread extends AppCompatActivity {
//    定义用到的三个控件
    private Button button;
    private TextView textView;
    private ProgressBar progressBar;

//    要做进度更新，首先要有个进度值
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0603_run_on_ui_thread);

//        找到对应的控件
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

//        设置按钮的点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                弹出一个提示
//                第一个参数是上下文，第二个参数是要显示的数据，第三个参数是toast显示的时长。最后让这个toast事件显示出来
                Toast.makeText(getApplicationContext(),"测试中",Toast.LENGTH_SHORT).show();
            }
        });

////        因为progressbar操作比较耗时，所以我们要放到另一个线程来。首先我们要让他的进度来更新。
//        Thread thread = new Thread(new Runnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
//                    不停的循环，加加
                    progress++;
//                    使用runOnUiThread更新UI控件
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //UI控件更新
                            textView.setText(progress + "%");
                            progressBar.setProgress(progress);
                        }
                    });
//                    当加到一百的时候，归零
//                    这个例子是反复循环，实际项目中可能会进行页面跳转或其他处理
                    if(progress > 100){
                        progress = 0;
                    }
//                    为了看到这个效果，我们要给这个程序加个延时。处理一下这个异常。
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

////        我们线程new出来了,但是还没有启动
//        thread.start();
    }
}