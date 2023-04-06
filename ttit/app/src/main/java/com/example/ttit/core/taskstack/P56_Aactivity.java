package com.example.ttit.core.taskstack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ttit.R;

public class P56_Aactivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p56_a_layout);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1.演示 standard模式: A-standard
//                startActivity(new Intent(P56_Aactivity.this, P56_Aactivity.class));

                //2.演示 singleTop模式: A-standard B-singleTop
//                startActivity(new Intent(P56_Aactivity.this, Bactivity.class));

                //3.演示 singleTask模式: A-singleTask  B-standard C-standard
//                startActivity(new Intent(P56_Aactivity.this, Bactivity.class));

                //4.演示 singleInstance:  A-singleInstance  B-singleInstance
//                startActivity(new Intent(P56_Aactivity.this, P57_Bactivity.class));
            }
        });
    }
}
