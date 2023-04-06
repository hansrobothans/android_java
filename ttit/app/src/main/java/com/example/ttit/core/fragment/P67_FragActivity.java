package com.example.ttit.core.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.ttit.R;

public class P67_FragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p67_frag);

        //动态添加Fragment
//        新建P67_MyFragment2对象，以用于动态加载
        P67_MyFragment2 myFragment = new P67_MyFragment2();

//        添加传入数据
        Bundle b = new Bundle();
        b.putString("name", "jack");
        myFragment.setArguments(b);

//        设置自定义回调事件
        myFragment.setCallBack(new P67_MyFragment2.CallBack() {
            @Override
            public void getResult(String result) {
                Log.e("ttit", "result = " + result);
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //第一个参数，要传入的容器（即main activity layout的子布局，比如RelativeLayout），
        // 第二个参数fragment对象
        ft.add(R.id.rl_fragment, myFragment);
//        ft.replace(R.id.rl_fragment, myFragment);
//        ft.remove(myFragment);
//        ft.addToBackStack(null); //将事务添加到回退栈
        ft.commit();
    }
}