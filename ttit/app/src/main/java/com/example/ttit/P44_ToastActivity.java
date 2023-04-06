package com.example.ttit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class P44_ToastActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p44_toast);

        mContext = this;

        final Toast toast = Toast.makeText(mContext, "吐司提示文本信息", Toast.LENGTH_SHORT);
        //设置Toast显示的位置
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

        //自定义toast布局
//        获取toast布局对象
        LinearLayout layout = (LinearLayout) toast.getView();
//        获取toast布局中TextView对象
        TextView v = layout.findViewById(android.R.id.message);
//        设置toast消息显示颜色
        v.setTextColor(Color.parseColor("#F86C37"));
//        设置toast布局背景颜色
        layout.setBackgroundColor(Color.BLUE);
//        创建一个ImageView控件对象
        ImageView image = new ImageView(this);
//        设置ImageView控件图片
        image.setImageResource(R.mipmap.ic_launcher_round);
//        给toast布局添加一个ImageView控件
        layout.addView(image, 0);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });
    }
}