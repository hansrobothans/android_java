package com.example.ttit.core.taskstack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ttit.R;

public class P57_Bactivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p57_b_layout);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //2.演示 singleTop模式:
//                startActivity(new Intent(P57_Bactivity.this, P57_Bactivity.class));

                //3.演示 singleTask模式:
//                startActivity(new Intent(P57_Bactivity.this, P58_Cactivity.class));

                //4.演示 singleInstance模式:
//                startActivity(new Intent(P57_Bactivity.this, P56_Aactivity.class));
            }
        });
    }
}
