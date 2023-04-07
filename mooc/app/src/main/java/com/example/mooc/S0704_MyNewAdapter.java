package com.example.mooc;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class S0704_MyNewAdapter extends PagerAdapter {
//    9.声明一个list view，这是放view对象的
    List<View> views;
//    10.我们写个构造方法，让这个view传进来。鼠标右键-》Generate-》Constructor
    public S0704_MyNewAdapter(List<View> views) {
        this.views = views;
    }
//    11.接下来我们改写第一个方法，获取view的数量
    @Override
    public int getCount() {
        return views.size();
    }
//    12.这个view是否是来自object
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
//    13.接着还要重写两个方法
//    怎么来销毁选项，我们可以直接调用viewpager的remove方法
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        首先将container强制转换成viewpager，然后调用viewpager的remove方法，remove当前的pager
        ((ViewPager)container).removeView(views.get(position));
    }
//    初始保有
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ((ViewPager)container).addView(views.get(position));
//        然后将这个view返回
        return views.get(position);
    }
}
