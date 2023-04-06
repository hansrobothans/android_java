package com.example.ttit.ui;
//获取布局参数，并在log中显示出来
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ttit.R;

public class P19_LayoutParamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p19_layout_params);
    }
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