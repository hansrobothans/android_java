package com.example.ttit.core.provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ttit.R;

public class P66_ContentProvider2Activity extends AppCompatActivity {
    private Button btninsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p66_content_provider2);

        btninsert = (Button) findViewById(R.id.btninsert);
        //读取contentprovider 数据
        final ContentResolver resolver = this.getContentResolver();
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name", "测试");
                Uri uri = Uri.parse("content://com.example.ttit.core..providers.myprovider/test");
                resolver.insert(uri, values);
                Toast.makeText(getApplicationContext(), "数据插入成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}