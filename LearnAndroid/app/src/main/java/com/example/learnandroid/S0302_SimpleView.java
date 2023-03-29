package com.example.learnandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class S0302_SimpleView extends AppCompatActivity {

//    把布局用到的控件都声明出来
    private Button button;
    private TextView textView;
    private ImageView imageView;
    private EditText editText;
    private RadioGroup radioGroup;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0302_simple_view);

//        通过findViewById找到对应的控件
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBox);

//        设置按键的点击事件，来监听按键的点击
//        当按键按下的时候，将editText输入的内容显示到textView里面
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                获取editText输入的内容
                String edit = editText.getText().toString();
//                将获取到的输入显示出来
                textView.setText(edit);
//                顺便将imageView的图片也改一下
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        });
//        监听radioGroup被选中
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                如果第一个按钮被选中就弹出一个提示
                if(i == R.id.radioButton1){
                    Toast.makeText(getApplicationContext(),"radioButton1被选中",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"radioButton2被选中",Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(),"checkBox被选中",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"checkBox未被选中",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}