package com.example.ttit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ttit.R;
import com.example.ttit.entity.P41_Icon;

import java.util.List;

public class P41_GridViewAdpater extends BaseAdapter {
    private List<P41_Icon> mData;
    private Context mContext;

    public P41_GridViewAdpater(List<P41_Icon> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {

            holder = new ViewHolder();

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_p41_grid_icon
                    , parent
                    , false);

            holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            holder.name = (TextView) convertView.findViewById(R.id.txt_icon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img_icon.setImageResource(mData.get(position).getIconId());
        holder.name.setText(mData.get(position).getName());

        return convertView;
    }

    static class ViewHolder {
        private ImageView img_icon;
        private TextView name;
    }
}
