package com.example.ttit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ttit.R;
import com.example.ttit.ui.adapter.P41_GridViewAdpater;
import com.example.ttit.ui.entity.P41_Icon;

import java.util.ArrayList;
import java.util.List;

public class P41_GridViewActivity extends AppCompatActivity {
    private Context mContext;
    private GridView grid_photo;
    private P41_GridViewAdpater mAdapter = null;
    private List<P41_Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p41_grid_view);

        mContext = this;
        //视图层V
        grid_photo = (GridView) findViewById(R.id.gridView);
        //数据源M
        mData = new ArrayList();
        mData.add(new P41_Icon(R.mipmap.iv_icon_1, "图标1"));
        mData.add(new P41_Icon(R.mipmap.iv_icon_2, "图标2"));
        mData.add(new P41_Icon(R.mipmap.iv_icon_3, "图标3"));
        mData.add(new P41_Icon(R.mipmap.iv_icon_4, "图标4"));
        mData.add(new P41_Icon(R.mipmap.iv_icon_5, "图标5"));
        mData.add(new P41_Icon(R.mipmap.iv_icon_6, "图标6"));
        mData.add(new P41_Icon(R.mipmap.iv_icon_7, "图标7"));
        //控制层C
        mAdapter = new P41_GridViewAdpater(mData, mContext);

        grid_photo.setAdapter(mAdapter);
        //点击事件
        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}