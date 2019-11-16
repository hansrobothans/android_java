package com.example.myapplication;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.GestureDetector.*;



public class NewActivity extends Activity
{
    private TextView showView=null;//定义结果组件
    private EditText edt=null;//定义编辑框组件
    private Button btn=null;//定义确定按钮
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newone);
        //获取结果组件
        this.showView=(TextView)super.findViewById(R.id.txt);
        //获取编辑框组件
        this.edt=(EditText)super.findViewById(R.id.edt);
        //获取确定按钮组件
        this.btn=(Button)super.findViewById((R.id.btn));
        btn.setOnClickListener(new ShowListener());
    }
    //定义监听处理事件
    private class ShowListener implements OnClickListener
    {

        @Override
        public void onClick(View V)
        {
            // TODO: Implement this method
            String sum=edt.getText().toString();
            showView.setText(sum);

        }
    }
}
