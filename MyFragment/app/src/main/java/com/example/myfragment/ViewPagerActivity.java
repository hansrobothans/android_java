package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.myfragment.Adapter.ViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

//        新建布局对象并绑定
        ViewPager2 viewPager = findViewById(R.id.viewPager);
//        新建adapter。需要有ViewPagerAdapter类，所以新建一个类
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
//        设置适配器，需要viewPager的adapter，所以需要新建adapter。
        viewPager.setAdapter(viewPagerAdapter);
    }
}