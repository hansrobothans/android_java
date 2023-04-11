package com.example.bluetoothspp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bluetoothspp.adapter.AdapterBluetoothSPPScan;
import com.example.bluetoothspp.bluetooth.BLESPPUtils;
import com.example.bluetoothspp.entity.ItemBluetoothSPPScan;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BLESPPUtils.OnBluetoothAction, View.OnClickListener {
    //    声明一个ItemBluetoothSPPScan类型的数组
    private List<ItemBluetoothSPPScan> mData = null;
    private AdapterBluetoothSPPScan mAdapter = null;
    //    声明ListView控件
    private ListView listView;
    //    声明扫描按钮控件
    private ImageView btAddNew;
    //    上下文
    private Context mContext;

    // 蓝牙工具
    private BLESPPUtils mBLESPPUtils;
    // 保存搜索到的设备，避免重复
    private ArrayList<BluetoothDevice> mDevicesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        上下文赋值
        mContext = this;
        // 申请权限
        initPermissions();

//        绑定控件
        listView = (ListView) findViewById(R.id.listview);
        btAddNew = (ImageView) findViewById(R.id.bt_start_scan);
//        绑定点击事件
        btAddNew.setOnClickListener(this);

        // 初始化
        mBLESPPUtils = new BLESPPUtils(this, this);
        // 启用日志输出
        mBLESPPUtils.enableBluetooth();
        // 设置接收停止标志位字符串
        mBLESPPUtils.setStopString("\r\n");
        // 用户没有开启蓝牙的话打开蓝牙
        if (!mBLESPPUtils.isBluetoothEnable()) mBLESPPUtils.enableBluetooth();

        // 启动工具类
        mBLESPPUtils.onCreate();


//        手动生成数据
        mData = new ArrayList<ItemBluetoothSPPScan>();
//        for (int i = 0; i < 20; i++) {
//            mData.add(new ItemBluetoothSPPScan("Name" + i, "Address" + i));
//        }

//        新建adapter
        mAdapter = new AdapterBluetoothSPPScan(mData, mContext);
//        设置adapter
        listView.setAdapter(mAdapter);
//        设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "点击了第" + position + "条数据", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBLESPPUtils.onDestroy();
    }

    /**
     * 申请运行时权限，不授予会搜索不到设备
     */
    private void initPermissions() {
        String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS, Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_PRIVILEGED};
        String[] PERMISSIONS_LOCATION = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS, Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_PRIVILEGED};
        int permission1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permission2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN);
        if (permission1 != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 1);
        } else if (permission2 != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_LOCATION, 1);
        }
    }

    //    点击刷新按钮,刷新listview
    @Override
    public void onClick(View v) {
//        点击开始扫描按钮
        if (v.getId() == R.id.bt_start_scan) {
//            清除Adapter数据
            mAdapter.clear();
//            通知Adapter数据更改
            mAdapter.notifyDataSetChanged();
//            配置权限
            initPermissions();
//            开始搜索
            mBLESPPUtils.startDiscovery();
        }
    }

    /**
     * 当发现新设备
     *
     * @param device 设备
     */
    @Override
    public void onFoundDevice(BluetoothDevice device) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

        }
        Log.d("BLE", "发现设备 " + device.getName() + device.getAddress());
        // 判断是不是重复的
        for (int i = 0; i < mDevicesList.size(); i++) {
            if (mDevicesList.get(i).getAddress().equals(device.getAddress())) return;
        }
        // 添加，下次有就不显示了
        mDevicesList.add(device);
//        添加数据
        ItemBluetoothSPPScan mDevice = new ItemBluetoothSPPScan(device);
        mAdapter.addData(mDevice);
//        通知Adapter数据更改
        mAdapter.notifyDataSetChanged();
//        // 添加条目到 UI 并设置点击事件
//        mDeviceDialogCtrl.addDevice(device, new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View v) {
//                BluetoothDevice clickDevice = (BluetoothDevice) v.getTag();
//                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
//
//                }
//                postShowToast("开始连接:" + clickDevice.getName());
//                mLogTv.setText(mLogTv.getText() + "\n" + "开始连接:" + clickDevice.getName());
//                mBLESPPUtils.connect(clickDevice);
//            }
//        });
    }

    /**
     * 当连接成功
     *
     * @param device 设备
     */
    @Override
    public void onConnectSuccess(final BluetoothDevice device) {
        postShowToast("连接成功", new DoSthAfterPost() {
            @SuppressLint("SetTextI18n")
            @Override
            public void doIt() {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

                }
//                mLogTv.setText(mLogTv.getText() + "\n连接成功:" + device.getName() + " | " + device.getAddress());
//                mDeviceDialogCtrl.dismiss();
            }
        });
    }

    /**
     * 当连接失败
     *
     * @param msg 失败信息
     */
    @Override
    public void onConnectFailed(final String msg) {
        postShowToast("连接失败:" + msg, new DoSthAfterPost() {
            @SuppressLint("SetTextI18n")
            @Override
            public void doIt() {
//                mLogTv.setText(mLogTv.getText() + "\n连接失败:" + msg);
            }
        });
    }

    /**
     * 当接收到 byte 数组
     *
     * @param bytes 内容
     */
    @Override
    public void onReceiveBytes(final byte[] bytes) {
        postShowToast("收到数据:" + new String(bytes), new DoSthAfterPost() {
            @SuppressLint("SetTextI18n")
            @Override
            public void doIt() {
//                mLogTv.setText(mLogTv.getText() + "\n收到数据:" + new String(bytes));
            }
        });
    }

    /**
     * 当调用接口发送 byte 数组
     *
     * @param bytes 内容
     */
    @Override
    public void onSendBytes(final byte[] bytes) {
        postShowToast("发送数据:" + new String(bytes), new DoSthAfterPost() {
            @SuppressLint("SetTextI18n")
            @Override
            public void doIt() {
//                mLogTv.setText(mLogTv.getText() + "\n发送数据:" + new String(bytes));
            }
        });
    }

    /**
     * 当结束搜索设备
     */
    @Override
    public void onFinishFoundDevice() {
    }

    /**
     * 在主线程弹出 Toast
     *
     * @param msg 信息
     */
    private void postShowToast(final String msg) {
        postShowToast(msg, null);
    }

    /**
     * 在主线程弹出 Toast
     *
     * @param msg            信息
     * @param doSthAfterPost 在弹出后做点什么
     */
    private void postShowToast(final String msg, final DoSthAfterPost doSthAfterPost) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                if (doSthAfterPost != null) doSthAfterPost.doIt();
            }
        });
    }

    private interface DoSthAfterPost {
        void doIt();
    }
}