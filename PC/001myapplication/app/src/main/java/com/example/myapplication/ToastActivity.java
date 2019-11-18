package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast);
//        第一个参数:当前activity
//        第二个参数:要显示的内容
//        第三个参数:显示的时间长短
        Toast.makeText(ToastActivity.this,"我是提示内容",Toast.LENGTH_SHORT).show();
    }
}
