package com.example.learnandroid;
//1.先在res--》values-》themes-》themes.xml中隐藏标题栏
//2.在res新建menu文件夹，在res-》menu文件夹里新建menu.xml文件
//3.新建layout
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class T02_ToolBar extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t02_tool_bar);
        //初始化toolbar
        toolbar();
    }
    @SuppressLint("ResourceAsColor")
    public void toolbar() {
        toolbar = findViewById(R.id.toolbar);
        //标题
        toolbar.setTitle("LuFei");
        //子标题
        toolbar.setSubtitle("儿子");
        //logo
        toolbar.setLogo(R.drawable.dufu);
        //左侧图标
        toolbar.setNavigationIcon(R.drawable.libai);
        //标题颜色
        toolbar.setTitleTextColor(R.color.teal_200);
        //背景颜色
        toolbar.setBackgroundResource(R.color.white);
        //设置toolbar对象
        setSupportActionBar(toolbar);

//        左侧图标监听事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //拿到了item对象，我们有id
                switch (item.getItemId()) {
                    case R.id.menu1:
//                        当它被点击的时候，我们让他弹出对应内容
//                        第一个参数是上下文，第二个参数是要显示的数据，第三个参数是toast显示的时长。最后让这个toast事件显示出来
                        Toast.makeText(getApplicationContext(), "加入", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(), "提示", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(), "退出", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //初始化search
        getMenuInflater().inflate(R.menu.menu_main,menu);
        //获取搜索框菜单栏
        MenuItem menuItem = menu.findItem(R.id.search);
        //获取SearchView对象
        SearchView searchView= (SearchView) menuItem.getActionView();
        //设置搜索栏默认提示
        searchView.setQueryHint("请输入商品名");
        //默认搜索栏为展开状态
        searchView.setIconified(false);
        //设置搜索监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //输入搜索内容后提交时触发
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(T02_ToolBar.this, "您输入的内容"+query, Toast.LENGTH_SHORT).show();
                return false;
            }
            //输入内容改变时触发
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
}