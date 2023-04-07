package com.example.myfragment.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

//5.新建一个adapter类
public class MyFragmentPagerAdapter extends FragmentStateAdapter {
//    7.新建存储Fragment列表
    List<Fragment> fragmentList = new ArrayList<>();

    public MyFragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<Fragment> fragments) {
        super(fragmentManager, lifecycle);
//        8.构造方法需要传进来
        fragmentList = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        10.更改createFragment返回值
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
//        9.更改getItemCount返回值
        return fragmentList.size();
    }
}
