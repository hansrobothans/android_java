package com.example.ttit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.ttit.R;
import com.example.ttit.ui.adapter.P43_MExpandableListAdapter;
import com.example.ttit.ui.entity.P43_Group;
import com.example.ttit.ui.entity.P43_Item;

import java.util.ArrayList;

public class P43_ExpandableListViewActivity extends AppCompatActivity {
    private ArrayList<P43_Group> gData = null;
    private ArrayList<ArrayList<P43_Item>> iData = null;
    private ArrayList<P43_Item> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private P43_MExpandableListAdapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p43_expandable_list_view);

        mContext = this;
        exlist_lol = findViewById(R.id.exlist_lol);


        //数据准备
        gData = new ArrayList<P43_Group>();
//        iData是一个P43_Item列表类型的列表.相当于二位数组
        iData = new ArrayList<ArrayList<P43_Item>>();

        gData.add(new P43_Group("AD"));
        gData.add(new P43_Group("AP"));
        gData.add(new P43_Group("TANK"));

        lData = new ArrayList<P43_Item>();

        //AD组
        lData.add(new P43_Item(R.mipmap.iv_lol_icon3, "剑圣"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon4, "德莱文"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon13, "男枪"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon14, "韦鲁斯"));
        iData.add(lData);
        //AP组
        lData = new ArrayList<P43_Item>();
        lData.add(new P43_Item(R.mipmap.iv_lol_icon1, "提莫"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon7, "安妮"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon8, "天使"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon9, "泽拉斯"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon11, "狐狸"));
        iData.add(lData);
        //TANK组
        lData = new ArrayList<P43_Item>();
        lData.add(new P43_Item(R.mipmap.iv_lol_icon2, "诺手"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon5, "德邦"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon6, "奥拉夫"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon10, "龙女"));
        lData.add(new P43_Item(R.mipmap.iv_lol_icon12, "狗熊"));
        iData.add(lData);

        myAdapter = new P43_MExpandableListAdapter(gData, iData, mContext);
        exlist_lol.setAdapter(myAdapter);


        //为列表设置点击事件
        exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(mContext, "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}