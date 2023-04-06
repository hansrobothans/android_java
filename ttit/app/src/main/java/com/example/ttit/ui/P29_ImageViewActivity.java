package com.example.ttit.ui;
//当使用src填入图片时,是按照图片大小直接填充,并不会进行拉伸,
// 而使用background填入图片,则是会根据ImageView给定的宽度来进行拉伸
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ttit.R;

public class P29_ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p29_image_view);
    }
}