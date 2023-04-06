package com.example.ttit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ttit.R;

//2.实现按钮接口
public class P34_ScrollViewActivity extends AppCompatActivity implements View.OnClickListener {
//    1.声明控件
    private Button btn_down;
    private Button btn_up;
    private ScrollView scrollView;
    private TextView txt_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p34_scroll_view);

//        12.调用绑定控件方法
        bindViews();
//        13.运行
    }

//    3.绑定控件
    private void bindViews() {
//        3.绑定对应控件
        btn_down = (Button) findViewById(R.id.btn_down);
        btn_up = (Button) findViewById(R.id.btn_up);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        txt_show = (TextView) findViewById(R.id.txt_show);
//        4.注册监听事件，类已经实现接口
        btn_down.setOnClickListener(this);
        btn_up.setOnClickListener(this);

//        5.定义字符串变量
        StringBuilder sb = new StringBuilder();
//        6.增加字符串变量以填充textView
        for (int i = 1; i <= 100; i++) {
            sb.append("我是一条文本内容 * " + i + "\n");
        }
//        7.填充textView文本
        txt_show.setText(sb.toString());

    }

//    8.实现按钮点击事件接口
    @Override
    public void onClick(View v) {
//        9.判断控件id以判断是哪个按钮
        switch (v.getId()) {
            case R.id.btn_down:
//                10.如果是down id按钮，则滚动视图控件滑动到底部
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                break;
            case R.id.btn_up:
//                11.如果是up id按钮，则滚动视图控件滑动到顶部
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
        }
    }
}