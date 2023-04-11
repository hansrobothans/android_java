package com.example.myfragment;
//ViewPager2 中的 Fragment 动态修改文本
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfragment.Adapter.T01MyFragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class T01MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager2 viewPager2;
    private List<Fragment> fragmentList;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t01_main);

        button = findViewById(R.id.bt_t01);
        button.setOnClickListener(this);

        viewPager2 = findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragmentList.add(new T01MyPageFragment());
        }
        viewPager2.setAdapter(new T01MyFragmentStateAdapter(this, fragmentList));

        changeText(0,"你好");
    }

    // 改变文本
    public void changeText(int position, String text) {
        T01MyPageFragment fragment = (T01MyPageFragment) fragmentList.get(position);
        if (fragment != null) {
            fragment.changeText(text);
        }
    }


    @Override
    public void onClick(View v) {
        changeText(1,"haha");
    }
}