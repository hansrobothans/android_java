package com.example.ttit.core.broadcastreceiver;
//1.需将P63_BActivity中静态注册注释掉，动态注册取消注释
//P63_AActivity有个按钮，按下跳转到P63_BActivity。
//跳转后P63_AActivity有个按钮虽然不可见，但是在栈里P63_BActivity下面，还没有被销毁
//按下发送广播按钮，动态接收器接收到广播发出提示

//2.需将P63_BActivity中动态注册注释掉，静态注册取消注释
//P63_AActivity有个按钮，按下跳转到P63_BActivity。
//按下发送广播按钮，静态接收器接收到广播发出提示
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ttit.R;

public class P63_AActivity extends AppCompatActivity {
    private P63_DynamicBRReceiver dynamicBRReceiver;
    private NetReceiver netReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p63_aactivity);

        // 动态注册广播接收器
        dynamicBRReceiver = new P63_DynamicBRReceiver();
        IntentFilter itFilter = new IntentFilter();
        itFilter.addAction("com.example.ttit.core.broadcastreceiver.DynamicBRReceiver");
        registerReceiver(dynamicBRReceiver, itFilter);

        //接受系统发出的广播
        netReceiver = new NetReceiver();
        IntentFilter itFilterNet = new IntentFilter();
//        网络变化的广播
        itFilterNet.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netReceiver, itFilterNet);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(P63_AActivity.this, P63_BActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicBRReceiver);
        unregisterReceiver(netReceiver);
    }

    //接收系统广播
    class NetReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "NetReceiver: 网络状态发送变化！！！", Toast.LENGTH_SHORT).show();
        }
    }
}