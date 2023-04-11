package com.example.bluetoothspp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bluetoothspp.adapter.AdapterBluetoothSPPScan;
import com.example.bluetoothspp.entity.ItemBluetoothSPPScan;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //    声明一个ItemBluetoothSPPScan类型的数组
    private List<ItemBluetoothSPPScan> mData = null;
    private AdapterBluetoothSPPScan mAdapter = null;
    //    声明ListView控件
    private ListView listView;
    //    声明扫描按钮控件
    private ImageView btAddNew;
    //    上下文
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        上下文赋值
        mContext = this;
//        绑定控件
        listView = (ListView) findViewById(R.id.listview);
        btAddNew = (ImageView) findViewById(R.id.bt_start_scan);

//        绑定点击事件
        btAddNew.setOnClickListener(this);


//        手动生成数据
        mData = new ArrayList<ItemBluetoothSPPScan>();
        for (int i = 0; i < 20; i++) {
            mData.add(new ItemBluetoothSPPScan("Name" + i, "Address" + i));
        }

//        新建adapter
        mAdapter = new AdapterBluetoothSPPScan(mData, mContext);
//        设置adapter
        listView.setAdapter(mAdapter);
//        设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "点击了第" + position + "条数据", Toast.LENGTH_SHORT).show();
            }
        });
//        设置长按事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "长按了第" + position + "条数据", Toast.LENGTH_SHORT).show();

//                长按被触发，触发后item长按状态 自动 消失，并且不会触发点击。
//                return true;
//                长按被触发，松手后点击被触发。且不松手一直处于长按状态。
                return false;
            }
        });
    }

    //    点击刷新按钮,刷新listview
    @Override
    public void onClick(View v) {
//        点击开始扫描按钮
        if (v.getId() == R.id.bt_start_scan) {
////            清除数据
//            mData.clear();
////            删除所有视图
//            listView.removeAllViewsInLayout();
//            for (int i = 10; i < 20; i++) {
//                mData.add(new ItemBluetoothSPPScan("Name" + i, "Address" + i));
//            }
//            mAdapter = new AdapterBluetoothSPPScan(mData, mContext);
//            listView.setAdapter(mAdapter);

//            清除Adapter数据
            mAdapter.clear();
//            通知Adapter数据更改
//            mAdapter.notifyDataSetChanged();
            for (int i = 10; i < 20; i++) {
                mAdapter.addData(new ItemBluetoothSPPScan("Name" + i, "Address" + i));
            }
//            通知Adapter数据更改
            mAdapter.notifyDataSetChanged();
        }


    }
}