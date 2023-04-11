package com.example.myfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class T01MyPageFragment extends Fragment {
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_view_page_1, container, false);
        tv = view.findViewById(R.id.tv_title);
        return view;
    }

    // 改变文本
    public void changeText(String text) {
        if (tv != null) {
            tv.setText(text);
        }
    }
}
