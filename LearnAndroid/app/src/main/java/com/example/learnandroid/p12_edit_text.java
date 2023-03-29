package com.example.learnandroid;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class p12_edit_text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        p12_edit_text
        setContentView(R.layout.p12_edit_text);
        EditText etName = findViewById(R.id.etName);
//        获取焦点
        etName.requestFocus();
//        设置光标启动初始位置
        etName.setSelection(2);
    }
}