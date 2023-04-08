package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myfragment.Adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;

//15.4. 实现接口View.OnClickListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //    1.声明布局
    ViewPager2 viewPager;
//    15.1. 新建布局
    private LinearLayout llDevices,llTalk,llPortrait,llButton,llSettings;
    private ImageView ivDevices,ivTalk,ivPortrait,ivButton,ivSettings,ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        2.定义一个专门的函数
        initPager();
//        15.2. 初始化tabView
        initTabView();

    }

//    15.3.新建tabView
    private void initTabView() {
//        15.6. 绑定控件，绑定监听方法
        llDevices = findViewById(R.id.device_lay);
        llDevices.setOnClickListener(this);
        llTalk = findViewById(R.id.talk_lay);
        llTalk.setOnClickListener(this);
        llPortrait = findViewById(R.id.portrait_lay);
        llPortrait.setOnClickListener(this);
        llButton = findViewById(R.id.button_lay);
        llButton.setOnClickListener(this);
        llSettings = findViewById(R.id.settings_lay);
        llSettings.setOnClickListener(this);

        ivDevices = findViewById(R.id.device_img);
        ivTalk = findViewById(R.id.talk_img);
        ivPortrait = findViewById(R.id.portrait_img);
        ivButton = findViewById(R.id.button_img);
        ivSettings = findViewById(R.id.settings_img);

//        15.7页面启动默认选择第一个界面
        ivDevices.setSelected(true);
        ivCurrent = ivDevices;

    }

    //    2.定义一个专门的函数
    private void initPager() {
//        3.绑定控件
        viewPager = findViewById(R.id.id_viewpager);

//        13.新建Fragment列表
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("设备连接"));
        fragments.add(BlankFragment.newInstance("对话模式"));
        fragments.add(BlankFragment.newInstance("专业调试"));
        fragments.add(BlankFragment.newInstance("按钮控制"));
        fragments.add(BlankFragment.newInstance("设置"));


//        6.新建adapter对象.需要知道有多少个.所以需要在MyFragmentPagerAdapter新建个列表.
//        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter();
//        11.新建adapter对象.传入对应参数.getLifecycle()是安卓中非常重要的jetpack组件.第三个参数需要传入Fragment,这个时候需要创建Fragment
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragments);


//        4.设置adapter.需要新建一个类.
        viewPager.setAdapter(pagerAdapter);
//        15.8.ViewPager画的监听接口
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                15.9. 滚动的动画添加在此处
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                15.10. 界面改变，做出菜单栏改变
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

//    15.11.根据传入参数，选择工具栏
    private void changeTab(int position) {
//        15.12. 图像控件先取消当前的，再打开指定的
        ivCurrent.setSelected(false);
        switch (position){
//            15.14. 根据id值，设置对应的ViewPagerItem
            case R.id.device_lay:
                viewPager.setCurrentItem(0);
            case 0:
                ivDevices.setSelected(true);
                ivCurrent = ivDevices;
                break;
            case R.id.talk_lay:
                viewPager.setCurrentItem(1);
            case 1:
                ivTalk.setSelected(true);
                ivCurrent =ivTalk;
                break;
            case R.id.portrait_lay:
                viewPager.setCurrentItem(2);
            case 2:
                ivPortrait.setSelected(true);
                ivCurrent = ivPortrait;
                break;
            case R.id.button_lay:
                viewPager.setCurrentItem(3);
            case 3:
                ivButton.setSelected(true);
                ivCurrent = ivButton;;
                break;
            case R.id.settings_lay:
                viewPager.setCurrentItem(4);
            case 4:
                ivSettings.setSelected(true);
                ivCurrent = ivSettings;
                break;
        }
    }

    //    15.5. 控件点击监听事件实现方法
    @Override
    public void onClick(View v) {
//        15.13. 当点击的时候，调用changeTab设置对应adapter
        changeTab(v.getId());

    }
}