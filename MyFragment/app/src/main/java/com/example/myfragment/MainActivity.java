package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.myfragment.Adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //    1.声明布局
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        2.定义一个专门的函数
        initPager();
    }

    //    2.定义一个专门的函数
    private void initPager() {
//        3.绑定控件
        viewPager = findViewById(R.id.id_viewpager);

//        13.新建Fragment列表
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("微信聊天"));
        fragments.add(BlankFragment.newInstance("通讯录"));
        fragments.add(BlankFragment.newInstance("发现"));
        fragments.add(BlankFragment.newInstance("我的"));


//        6.新建adapter对象.需要知道有多少个.所以需要在MyFragmentPagerAdapter新建个列表.
//        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter();
//        11.新建adapter对象.传入对应参数.getLifecycle()是安卓中非常重要的jetpack组件.第三个参数需要传入Fragment,这个时候需要创建Fragment
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragments);


//        4.设置adapter.需要新建一个类.
        viewPager.setAdapter(pagerAdapter);
    }
}