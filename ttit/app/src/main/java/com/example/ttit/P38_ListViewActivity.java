package com.example.ttit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ttit.adapter.P38_NewsAdapter;
import com.example.ttit.entity.P38_News;
import com.example.ttit.adapter.P38_NewsAdapter2;

import java.util.ArrayList;
import java.util.List;

public class P38_ListViewActivity extends AppCompatActivity {
//    声明一个P38_News类型的数组
    private List<P38_News> mData = null;
//    上下文
    private Context mContext;

    private P38_NewsAdapter mAdapter = null;
//    private P38_NewsAdapter2 mAdapter = null;

//    声明ListView控件
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p38_list_view);
//        上下文赋值
        mContext = this;
//        绑定控件
        listView = (ListView) findViewById(R.id.listview);

        mData = new ArrayList<P38_News>();
        for (int i = 0; i < 20; i++) {
            mData.add(new P38_News("我是一个新闻标题---- " + i, "我是一个新闻内容---- " + i, R.mipmap.news));
        }
//        只有一种item。打开这个也需要打开25行声明
        mAdapter = new P38_NewsAdapter(mData, mContext);
//        两种item。打开这个也需要打开26行声明
//        mAdapter = new P38_NewsAdapter2(mData, mContext);
        listView.setAdapter(mAdapter);
//        设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "点击了第" + position + "条数据", Toast.LENGTH_SHORT).show();
            }
        });
//        设置长按事件
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "长按了第" + position + "条数据", Toast.LENGTH_SHORT).show();

//                长按被触发，触发后item长按状态 自动 消失，并且不会触发点击。
//                return true;
//                长按被触发，松手后点击被触发。且不松手一直处于长按状态。
                return false;
            }
        });
    }
}