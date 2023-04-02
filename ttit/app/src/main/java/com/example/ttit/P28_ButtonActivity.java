package com.example.ttit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class P28_ButtonActivity extends AppCompatActivity {
//    1.声明控件
    private Button btnOne, btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p28_button);

//        2.通过id找到对应控件
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);

//        3.设置按钮监听事件
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                4.如果第二个按钮按下,文本是"按钮不可用",则将第一个按钮使能状态设置为flase,否则设置为trye
//                浅绿色<item android:drawable="@color/teal_700" android:state_pressed="true"/>
//                蓝色<item android:drawable="@color/purple_700" android:state_enabled="false"/>
//                紫色<item android:drawable="@color/purple_200" />
                if (btnTwo.getText().toString().equals("按钮不可用")) {
                    btnOne.setEnabled(false);
                    btnTwo.setText("按钮可用");
                } else {
                    btnOne.setEnabled(true);
                    btnTwo.setText("按钮不可用");
                }
            }
        });
    }
}