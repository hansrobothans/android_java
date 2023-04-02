package com.example.ttit;
//运行实例化布局元素
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class P15_ViewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        1.动态创建布局
//        setContentView(R.layout.activity_p15_view_group);
//        2.新建约束布局对象
        ConstraintLayout constraintLayout = new ConstraintLayout(this);
//        3.新建文本控件
        TextView view = new TextView(this);
        view.setText("Hello World!");
        constraintLayout.addView(view);
////        4.新建按钮控件
//        Button button = new Button(this);
//        constraintLayout.addView(button);

//        5.加载布局资源
        setContentView(constraintLayout);
    }
}