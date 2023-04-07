package com.example.myfragment.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfragment.R;

//4. 新建ViewPagerAdapter类
public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {
    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        6.解析数据
        return new ViewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_page_1, parent, false));
    }

//    7.经过6之后，view已经做了适配，但是现在还没有做数据适配。
//    把数据传进来展示不同界面
    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //    5. 解析layout数据
    class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        //        item包含的控件
        TextView mTv;
        RelativeLayout mContainer;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
//            绑定控件
            mContainer = itemView.findViewById(R.id.container);
            mTv = itemView.findViewById(R.id.tv_title);
        }
    }
}
