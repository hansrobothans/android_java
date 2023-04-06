package com.example.ttit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class P46_MButton extends androidx.appcompat.widget.AppCompatButton {
    public P46_MButton(Context context) {
        super(context);
    }

    public P46_MButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public P46_MButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ttit", "MButton ://////onTouchEvent event ="+event.getAction());
//        return super.onTouchEvent(event);
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("ttit", "MButton ://////dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }
}
