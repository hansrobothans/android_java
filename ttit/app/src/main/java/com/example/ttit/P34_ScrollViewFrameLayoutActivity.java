package com.example.ttit;
//自己修改
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//实现按钮接口
public class P34_ScrollViewFrameLayoutActivity extends AppCompatActivity implements View.OnClickListener {
//    声明控件
    private Button btn_up;
    private Button btn_clean;
    private Button btn_down;
    private ScrollView scrollView;
    private TextView txt_show;

//    定义按键时填充还是清楚，默认清除
    private boolean cleanAdd = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p34_scroll_view_frame_layout);

//        调用绑定控件方法
        bindViews();
//        运行
    }

//    绑定控件
    private void bindViews() {
//       绑定对应控件
        btn_up = (Button) findViewById(R.id.btn_up);
        btn_clean = (Button) findViewById(R.id.btn_clean);
        btn_down = (Button) findViewById(R.id.btn_down);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        txt_show = (TextView) findViewById(R.id.txt_show);

//        注册监听事件，类已经实现接口
        btn_up.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
        btn_down.setOnClickListener(this);

//        填充scrollView内容
        scrollViewAdd();
    }

//    实现按钮点击事件接口
    @Override
    public void onClick(View v) {
//        Button button = (Button)v;
//        判断控件id以判断是哪个按钮
        switch (v.getId()) {
            case R.id.btn_up:
//                Toast.makeText(getApplicationContext(), "btn_up", Toast.LENGTH_SHORT).show();
//                如果是up id按钮，则滚动视图控件滑动到顶部
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
            case R.id.btn_clean:
//                Toast.makeText(getApplicationContext(), "btn_clean", Toast.LENGTH_SHORT).show();
                if (cleanAdd) {
                    scrollViewClean();
                    btn_clean.setText("填充全部");
                    cleanAdd = false;
                } else {
                    scrollViewAdd();
                    btn_clean.setText("清除全部");
                    cleanAdd = true;
                }
                break;
            case R.id.btn_down:
//                Toast.makeText(getApplicationContext(), "btn_down", Toast.LENGTH_SHORT).show();
//                如果是down id按钮，则滚动视图控件滑动到底部
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                break;
        }
    }

//    清空scrollView内容
    private void scrollViewClean() {
        //        定义字符串变量
        StringBuilder sb = new StringBuilder();
//        填充空的textView文本
        txt_show.setText(sb.toString());

    }

    //    填充scrollView内容
    private void scrollViewAdd(){
        //        定义字符串变量
        StringBuilder sb = new StringBuilder();
//        增加字符串变量以填充textView
        for (int i = 1; i <= 100; i++) {
            sb.append("我是一条文本内容 * " + i + "\n");
        }
//        填充textView文本
        txt_show.setText(sb.toString());

    }
}