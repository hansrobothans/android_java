package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterFactory;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class S0704_ViewPagerTest extends AppCompatActivity {
//    1.声明viewpageer
    private ViewPager viewPager;
//    3.接着将这几个界面放到一个list里面。把list声明出来
    private List<View> views;
//    15.要用这个adapter就需要先声明出来
    private S0704_MyNewAdapter myNewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0704_view_pager_test);

//        2.找到viewpager
        viewPager = findViewById(R.id.viewpager);
//        4.把这几个view装进views里面
        views = new ArrayList<View>();
//        5.将这三个layout打平。先拿到一个layout flater，即上下文。
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
//        6.再用这个layout flater，将这三个layout打平成view
        View view1  = layoutInflater.inflate(R.layout.s0704_a1,null);
        View view2  = layoutInflater.inflate(R.layout.s0704_a2,null);
        View view3  = layoutInflater.inflate(R.layout.s0704_a3,null);
//        7.然后将这三个view放到这个list view里面
        views.add(view1);
        views.add(view2);
        views.add(view3);
//        8.新建一个类S0704_MyNewAdapter
//        14.然后这个adapter就写完了
//        16.接下来我们来set adapter
        myNewAdapter = new S0704_MyNewAdapter(views);
//        17.然后来设置一下
        viewPager.setAdapter(myNewAdapter);
//        18.整个viewpager程序就写完了
    }
}