package com.example.ttit.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ttit.R;
import com.example.ttit.ui.entity.P38_News;

import java.util.List;

public class P38_NewsAdapter extends BaseAdapter {
    private List<P38_News> mData;
    private Context mContext;

    public P38_NewsAdapter(List<P38_News> mData, Context mContext) {
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

////  便于理解的一个版本(未优化)
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
////        反射器
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//
////        最后要返回一个View
////        显示不正常
////        View view = inflater.inflate(
////                R.layout.item_p38_listview_item_layout,
////                null);
////        直接程序崩
////        View view = inflater.inflate(
////                R.layout.item_p38_listview_item_layout,
////                parent);
////        可以正常显示
//        View view = inflater.inflate(
//                R.layout.item_p38_listview_item_layout,
//                parent,
//                false);
//
////        也可以使用传进来的一个定义好的用于转换的View
////        convertView = inflater.inflate(
////                R.layout.item_p38_listview_item_layout,
////                parent,
////                false);
//
////        绑定控件
//        ImageView img_icon = (ImageView) view.findViewById(R.id.img_icon);
//        TextView title = (TextView) view.findViewById(R.id.tv_title);
//        TextView content = (TextView) view.findViewById(R.id.tv_content);
//
////        完形填空即填充资源
//        img_icon.setBackgroundResource(mData.get(position).getaIcon());
//        title.setText(mData.get(position).getTitle());
//        content.setText(mData.get(position).getContent());
//
////        返回View
//        return view;
//    }


//  便于理解的一个版本(优化)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        反射器
        LayoutInflater inflater = LayoutInflater.from(mContext);

//        使用传进来的一个定义好的用于转换的View
        if(convertView == null){
            Log.d("getView","第"+position+"次给convertView赋值");
            convertView = inflater.inflate(
                    R.layout.item_p38_listview_item_layout,
                    parent,
                    false);
        }

//        绑定控件
        ImageView img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
        TextView title = (TextView) convertView.findViewById(R.id.tv_title);
        TextView content = (TextView) convertView.findViewById(R.id.tv_content);

//        完形填空即填充资源
        img_icon.setBackgroundResource(mData.get(position).getaIcon());
        title.setText(mData.get(position).getTitle());
        content.setText(mData.get(position).getContent());

//        返回View
        return convertView;
    }



////    课程未优化前的版本
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_p38_listview_item_layout, parent, false);
//        ImageView img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
//        TextView title = (TextView) convertView.findViewById(R.id.tv_title);
//        TextView content = (TextView) convertView.findViewById(R.id.tv_content);
//        img_icon.setBackgroundResource(mData.get(position).getaIcon());
//        title.setText(mData.get(position).getTitle());
//        content.setText(mData.get(position).getContent());
//        return convertView;
//    }




////    BaseAdapter 优化
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
////        第一次调用，convertView是空的
//        ViewHolder holder = null;
//        if (convertView == null) {
////            如果为空就创建个ViewHolder
//            holder = new ViewHolder();
////            加载布局文件
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_p38_listview_item_layout
//                    , parent
//                    , false);
//            holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
//            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
//            holder.content = (TextView) convertView.findViewById(R.id.tv_content);
////            缓存
//            convertView.setTag(holder);
//        } else {
////            如果不是空就取出来
//            holder = (ViewHolder) convertView.getTag();
//        }
//        holder.img_icon.setBackgroundResource(mData.get(position).getaIcon());
//        holder.title.setText(mData.get(position).getTitle());
//        holder.content.setText(mData.get(position).getContent());
//        return convertView;
//    }
//
//    static class ViewHolder {
//        ImageView img_icon;
//        TextView title;
//        TextView content;
//    }
}
