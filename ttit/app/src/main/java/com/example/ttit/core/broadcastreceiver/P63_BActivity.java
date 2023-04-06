package com.example.ttit.core.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ttit.R;

public class P63_BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p63_bactivity);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播

//                静态注册
////                下面是隐式发送。Android8.0以上系统不再支持该种方式
//                Intent intent = new Intent("com.example.ttit.core.broadcastreceiver.P64_StaticBRReceiver");
//                显示的发送
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(P63_BActivity.this, P64_StaticBRReceiver.class));
                sendBroadcast(intent);

//                //动态注册
//                Intent intent = new Intent("com.example.ttit.core.broadcastreceiver.DynamicBRReceiver");
//                sendBroadcast(intent);
            }
        });
    }
}