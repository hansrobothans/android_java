package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class p03_view_group extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.p03_view_group);
        ConstraintLayout constraintLayout = new ConstraintLayout(this);
        TextView view = new TextView(this);
        view.setText("Hello World!");
        constraintLayout.addView(view);
    }
}