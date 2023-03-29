package com.example.learnandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class p04_layout_params extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p15_radiobutton);
    }

//    p04_LayoutParams
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        TextView tv = findViewById(R.id.tv);
        float w = tv.getWidth();
        float h = tv.getHeight();
        float left = tv.getLeft();
        float top = tv.getTop();

        Log.e("ttit", "w =" + w);
        Log.e("ttit", "h =" + h);
        Log.e("ttit", "left =" + left);
        Log.e("ttit", "top =" + top);
    }
}