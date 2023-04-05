package com.example.ttit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ttit.R;
import com.example.ttit.entity.P42_Hero;

import java.util.List;

public class P42_SpinnerAdapter extends BaseAdapter {
    private List<P42_Hero> mData;
    private Context context;

    public P42_SpinnerAdapter(List<P42_Hero> mData, Context context) {
        this.mData = mData;
        this.context = context;
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

            convertView = LayoutInflater.from(context).inflate(R.layout.item_p42_spin_hero
                    , parent
                    , false);

            holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            holder.name = (TextView) convertView.findViewById(R.id.txt_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img_icon.setImageResource(mData.get(position).gethIcon());
        holder.name.setText(mData.get(position).gethName());

        return convertView;
    }

    static class ViewHolder {
        private ImageView img_icon;
        private TextView name;
    }
}
