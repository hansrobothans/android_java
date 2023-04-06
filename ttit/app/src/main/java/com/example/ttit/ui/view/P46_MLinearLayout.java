package com.example.ttit.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class P46_MLinearLayout extends LinearLayout {
    public P46_MLinearLayout(Context context) {
        super(context);
    }

    public P46_MLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ttit", "MLinearLayout ://////onTouchEvent event ="+event.getAction());
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("ttit", "MLinearLayout ://////onInterceptTouchEvent");
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("ttit", "MLinearLayout ://////dispatchTouchEvent");
//        return super.dispatchTouchEvent(ev);
        return true;
    }
}