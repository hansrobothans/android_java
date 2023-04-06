package com.example.ttit.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ttit.R;

import java.util.Calendar;

public class P36_DateTimeActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p36_date_time);

//        获取上下文
        mContext = this;
        mContext = getApplicationContext();

//        DatePicker
//        声明绑定控件
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

//        获取日历类对象，在java教程中日历那一块有讲
        Calendar calendar = Calendar.getInstance();

//        返回给定日历字段值
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

//        初始化日期选择器，并注册监听事件
        datePicker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                月份从0开始
                Toast.makeText(mContext, year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });

//        TimePicker
//        声明绑定控件
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
//        设置监听事件
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(mContext, hourOfDay + "时" + minute + "分", Toast.LENGTH_SHORT).show();
            }
        });

//        CalendarView
//        声明绑定控件
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
//        设置监听事件
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                月份从0开始
                Toast.makeText(mContext, year + "年" + (month + 1) + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });
    }
}