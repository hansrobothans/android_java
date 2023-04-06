package com.example.ttit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ttit.R;
import com.example.ttit.ui.adapter.P42_SpinnerAdapter;
import com.example.ttit.ui.entity.P42_Hero;

import java.util.ArrayList;

public class P42_SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//    声明控件
    private Spinner spin_one;
    private Spinner spin_two;
//    声明上下文
    private Context mContext;
//    判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;
    private boolean two_selected = false;
//    声明数据
    private ArrayList<P42_Hero> mData = null;
//    声明adapter
    private P42_SpinnerAdapter myAdadpter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p42_spinner);

//        赋值上下文
        mContext = this;
//        新建数据
        mData = new ArrayList<P42_Hero>();
//        绑定控件
        bindViews();
    }

    private void bindViews() {
//        绑定控件
        spin_one = (Spinner) findViewById(R.id.spin_one);
        spin_two = (Spinner) findViewById(R.id.spin_two);

//        填充数据
        mData.add(new P42_Hero(R.mipmap.iv_lol_icon1, "迅捷斥候：提莫（Teemo）"));
        mData.add(new P42_Hero(R.mipmap.iv_lol_icon2, "诺克萨斯之手：德莱厄斯（Darius）"));
        mData.add(new P42_Hero(R.mipmap.iv_lol_icon3, "无极剑圣：易（Yi）"));
        mData.add(new P42_Hero(R.mipmap.iv_lol_icon4, "德莱厄斯：德莱文（Draven）"));
        mData.add(new P42_Hero(R.mipmap.iv_lol_icon5, "德邦总管：赵信（XinZhao）"));
        mData.add(new P42_Hero(R.mipmap.iv_lol_icon6, "狂战士：奥拉夫（Olaf）"));

//        填充adapter
        myAdadpter = new P42_SpinnerAdapter(mData, mContext);

//        设置adapter
//        spinner_one在布局里面用字符串数组自动填充
//        spin_two使用adapter动态填充
        spin_two.setAdapter(myAdadpter);

//        设置监听事件.需要先实现接口
        spin_one.setOnItemSelectedListener(this);
        spin_two.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        parent是父视图容器,所以可以通过getId判断父视图是哪个
        switch (parent.getId()) {
            case R.id.spin_one:
                if (one_selected) {
                    Toast.makeText(mContext, "您的分段是~：" + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    one_selected = true;
                }
                break;
            case R.id.spin_two:
                if (two_selected) {
                    TextView txt_name = (TextView) view.findViewById(R.id.txt_name);
                    Toast.makeText(mContext, "您选择的英雄是~：" + txt_name.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    two_selected = true;
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}