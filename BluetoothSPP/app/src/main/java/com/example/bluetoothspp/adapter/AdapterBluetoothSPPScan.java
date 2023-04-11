package com.example.bluetoothspp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bluetoothspp.R;
import com.example.bluetoothspp.entity.ItemBluetoothSPPScan;

import java.util.List;

public class AdapterBluetoothSPPScan extends BaseAdapter {
    private List<ItemBluetoothSPPScan> mData;
    private Context mContext;

    public AdapterBluetoothSPPScan(List<ItemBluetoothSPPScan> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    //    必须写，系统会去调用。如果返回0，无论传进去多少条item，系统都不会显示
    @Override
    public int getCount() {
        return mData.size();
    }

    //    系统一般不会去调用
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    //    系统一般不会去调用
    @Override
    public long getItemId(int position) {
        return position;
    }


//    //  便于理解的一个版本(优化)
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
////        反射器
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//
////        使用传进来的一个定义好的用于转换的View
//        if(convertView == null){
//            Log.d("getView","第"+position+"次给convertView赋值");
//            convertView = inflater.inflate(
//                    R.layout.item_listview_bluetoothspp_scan,
//                    parent,
//                    false);
//        }
//
////        绑定控件
//        TextView name = (TextView) convertView.findViewById(R.id.tx_name);
//        TextView address = (TextView) convertView.findViewById(R.id.tx_address);
//
////        完形填空即填充资源
//        name.setText(mData.get(position).getName());
//        address.setText(mData.get(position).getAddress());
//
////        返回View
//        return convertView;
//    }

//    BaseAdapter 优化
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        第一次调用，convertView是空的
        ViewHolder holder = null;
        if (convertView == null) {
//            如果为空就创建个ViewHolder
            holder = new ViewHolder();
//            加载布局文件
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_bluetoothspp_scan
                    , parent
                    , false);
            holder.name = (TextView) convertView.findViewById(R.id.tx_name);
            holder.address = (TextView) convertView.findViewById(R.id.tx_address);
//            缓存
            convertView.setTag(holder);
        } else {
//            如果不是空就取出来
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(mData.get(position).getName());
        holder.address.setText(mData.get(position).getAddress());

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView address;
    }
}
