package com.example.learnandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class S0602_HandleMessage extends AppCompatActivity {
//    定义用到的三个控件
    private Button button;
    private TextView textView;
    private ProgressBar progressBar;

//    要做进度更新，首先要有个进度值
    private int progress = 0;

//    进度值是在子线程处理，而进度条是在主线程里更新
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
//        使用handleMessage来处理消息事,处理子线程发过来的消息
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
//            将接收到的消息,显示出来.textView显示第一个参数
            textView.setText(msg.arg1+"%");
//            然后progressBar也得显示
            progressBar.setProgress(msg.arg1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0602_handle_message);

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

//        因为progressbar操作比较耗时，所以我们要放到另一个线程来。首先我们要让他的进度来更新。
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
//                    不停的循环，加加
                    progress++;
//                    获取handler的消息
                    Message msg =  handler.obtainMessage();
//                    获取到消息,将消息放点内容.第一个参数,将进度放进去
                    msg.arg1 = progress;
//                    进度放进去之后,我们要将这个消息发布出去
                    handler.sendMessage(msg);
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
        });

//        我们线程new出来了,但是还没有启动
        thread.start();
    }


}