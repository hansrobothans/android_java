package com.example.mooc;
//首先新加ListView布局文件，其次新建item文件用于填充listview

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S0702_ListViewTest extends AppCompatActivity {
//    1.新建两个list view控件变量
    private ListView listView1,listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0702_list_view_test);

//        2.我们来找到两个list view
        listView1 = findViewById(R.id.listview1);
        listView2 = findViewById(R.id.listview2);

//        3.listView1使用arrayadapter来做的，它的数据字符串就可以了
        final String[] arr = new String[]{"Java","C++","Python"};

//        4.接下来就来做listview1的adapter，我们是要用arrayadapter
//        第一个参数是context，上下文，这边就是当前的上下文。
//        第二个参数是resource，是它的条目R.layout下面的item。
//        第三个参数是他的数据，这边就是arr。
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.s0702_list_view_item_text,arr);

//        5.我们把adapter设置进去
        listView1.setAdapter(arrayAdapter);

//        6.设置点击事件
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                7.当它被点击的时候，我们让他弹出对应内容
//                第一个参数是上下文，第二个参数是要显示的数据，第三个参数是toast显示的时长。最后让这个toast事件显示出来
                Toast.makeText(getApplicationContext(),arr[position],Toast.LENGTH_SHORT).show();
            }
        });

//        8.第二list view是用simple adapter来做

//        9.同样我们也需要它的数据，我们先把它的数据定义出来。
//        需要三个数据，一个是图像，一个名字，一个绰号。
//        然后我们把图像写过来,图像的id是int类型的
        final int[] heads = new int[]{R.drawable.libai,R.drawable.dufu};
//        然后我们再拿他们的名字和绰号
        final String[] names = new String[]{"李白","杜甫"};
        final String[] nicknames = new String[]{"诗仙","诗圣"};

//        10.我们拿到了头像，名字和绰号，我们现在要把它们组合到一起。先用list来组合。
        List list = new ArrayList();
//        这两个人的信息，我们放在map里面
        for(int i = 0;i < names.length;i++){
//            map第一个参数是key，key是字符串。第二个参数是value，value有view int、字符串，所以直接用Object。然后new一个hashmap
            Map<String,Object> item = new HashMap<>();
//            map里面放三个属性
            item.put("head",heads[i]);
            item.put("name",names[i]);
            item.put("nickname",nicknames[i]);
//            将这三个属性加到list里面
            list.add(item);
        }

//        11.写simple adapter。
//        第一个参数是context，上下文，这边就是当前的上下文。
//        第二个参数就是我们的数据，list。
//        第三个参数是layout。
//        第四个参数是from，从哪里到哪里，from有三个属性，head、name、nickname，是字符串。我们new出来。
//        然后是到哪里，分别是这个item的imageView、textView2和textView3
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                list,
                R.layout.s0702_list_view_item_simple,
                new String[]{"head","name","nickname"},
                new int[]{R.id.imageView,R.id.textView2,R.id.textView3}
                );
//        12.我们把adapter设置进去
        listView2.setAdapter(simpleAdapter);
//        13.设置点击事件
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                14.当它被点击的时候，我们让他弹出对应内容
//                第一个参数是上下文，第二个参数是要显示的数据,弹出名字，第三个参数是toast显示的时长。最后让这个toast事件显示出来
                Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}