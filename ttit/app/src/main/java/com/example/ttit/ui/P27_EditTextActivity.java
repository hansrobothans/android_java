package com.example.ttit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.ttit.R;

public class P27_EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p27_edit_text);

        EditText etName = findViewById(R.id.etName);
//        1.获取焦点
        etName.requestFocus();
//        2.设置光标启动初始位置
        etName.setSelection(2);

////        3.弹出键盘方法一
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
////        4.弹出键盘方法二
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘

//        5.以上两种方法,实际测试都无法弹出键盘

//        6.获取输入的文本
        etName.getText().toString().trim();
    }
}