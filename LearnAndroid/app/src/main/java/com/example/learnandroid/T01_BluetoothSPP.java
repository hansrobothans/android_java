package com.example.learnandroid;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothServerSocket;
//import android.bluetooth.BluetoothSocket;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import java.util.UUID;
//
//public class T01_BluetoothSPP extends AppCompatActivity {
//
//    TextView textView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.t01_bluetooth_spp);
//
//        TextView textView = findViewById(R.id.textView1);
//    }
//}
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

// 继承 Activity 类并实现接口 OnCreate() 方法
public class T01_BluetoothSPP extends Activity {
    // 设备名称
    private static final String NAME = "BluetoothSPP";
    // 蓝牙 UUID
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    // 获取设备蓝牙适配器
    private BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
    // 服务端 socket
    private AcceptThread mAcceptThread;
    // 客户端 socket
    private ConnectThread mConnectThread;
    // 正在运行的 socket
    private ConnectedThread mConnectedThread;
    // 状态常量
    private int mState;
    // 默认状态
    private static final int STATE_NONE = 0;
    // 正在连接
    private static final int STATE_CONNECTING = 1;
    // 连接成功
    private static final int STATE_CONNECTED = 2;

    // 管理 UI 的 Handler
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STATE_CONNECTED:
                    // 当连接成功时，展示提示信息
                    mTextView.setText("设备已连接");
                    break;
                case STATE_CONNECTING:
                    // 当正在连接时，展示提示信息
                    mTextView.setText("正在连接……");
                    break;
                case STATE_NONE:
                    // 当未连接时，展示提示信息
                    mTextView.setText("未连接");
                    break;
            }
        }
    };

    // 上下文
    private TextView mTextView;

    // Activity 的 OnCreate() 方法
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置 UI 布局
        setContentView(R.layout.t01_bluetooth_spp);

        // 获取 UI 组件
        mTextView = (TextView) findViewById(R.id.textView1);

        // 如果设备不支持蓝牙，则提示错误信息
        if (mAdapter == null) {
            mTextView.setText("设备不支持蓝牙。");
            return;
        }
    }

    // Activity 的 OnStart() 方法
    @Override
    public void onStart() {
        super.onStart();

        // 检查是否启用蓝牙
        if (!mAdapter.isEnabled()) {
            // 如果蓝牙未启用，则打开系统对话框让用户启用蓝牙
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, 1);
        } else {
            // 否则，启动 socket 服务
            if (mAcceptThread == null) {
                mAcceptThread = new AcceptThread();
                mAcceptThread.start();
            }
        }
    }

    // 在 Activity 的 onDestroy() 方法中停止所有线程
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopAllThreads();
    }

    // 结束所有线程
    private synchronized void stopAllThreads() {
        // 停止连接线程
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }

        // 停止连接成功后的线程
        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }

        // 停止服务端接受请求的线程
        if (mAcceptThread != null) {
            mAcceptThread.cancel();
            mAcceptThread = null;
        }

        // 重置设备当前状态为未连接态
        setState(STATE_NONE);
    }

    // 设置设备当前状态
    private synchronized void setState(int state) {
        mState = state;

        // 发送状态变化消息
        mHandler.obtainMessage(state).sendToTarget();
    }

    // 获取当前设备连接状态
    public synchronized int getState() {
        return mState;
    }

    // 开启一个新的连接
    public synchronized void connect(BluetoothDevice device) {
        // 如果当前状态为正在连接态，则停止连接线程并返回
        if (mState == STATE_CONNECTING) {
            if (mConnectThread != null) {
                mConnectThread.cancel();
                mConnectThread = null;
            }
            return;
        }

        // 如果当前状态为已连接态，则停止连接成功后的线程并返回
        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }

        // 创建新的连接线程
        mConnectThread = new ConnectThread(device);
        mConnectThread.start();

        // 将设备状态设置为正在连接态
        setState(STATE_CONNECTING);
    }

    // 用于已经连接的线程
    public synchronized void connected(BluetoothSocket socket, BluetoothDevice device) {
        // 停止连接线程
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }

        // 停止已连接线程
        if (mConnectedThread != null) {
            mConnectedThread.cancel();
            mConnectedThread = null;
        }

        // 停止服务端接受连接的线程
        if (mAcceptThread != null) {
            mAcceptThread.cancel();
            mAcceptThread = null;
        }

        // 创建已连接线程
        mConnectedThread = new ConnectedThread(socket);
        mConnectedThread.start();

        // 发送设备已连接消息
        setState(STATE_CONNECTED);
    }

    // 连接失败
    private void connectionFailed() {
        setState(STATE_NONE);
    }

    // 连接丢失
    private void connectionLost() {
        setState(STATE_NONE);
    }

    // 监听连接请求的线程
    private class AcceptThread extends Thread {
        private final BluetoothServerSocket mmServerSocket;

        public AcceptThread() {
            BluetoothServerSocket tmp = null;

            // 创建一个监听 socket
            try {
                tmp = mAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
            } catch (IOException e) {
                Log.e("TAG", "监听连接请求失败");
            }

            mmServerSocket = tmp;
        }

        public void run() {
            setName("AcceptThread");

            BluetoothSocket socket = null;

            // 监听连接请求
            while (mState != STATE_CONNECTED) {
                try {
                    socket = mmServerSocket.accept();
                } catch (IOException e) {
                    break;
                }

                // 如果连接未启用或已连接，则忽略，否则启动已连接的线程
                if (socket != null) {
                    synchronized (T01_BluetoothSPP.this) {
                        switch (mState) {
                            case STATE_CONNECTING:
                                connected(socket, socket.getRemoteDevice());
                                break;
                            case STATE_NONE:
                            case STATE_CONNECTED:
                                try {
                                    socket.close();
                                } catch (IOException e) {
                                }
                                break;
                        }
                    }
                }
            }

            // 关闭 socket
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                Log.e("TAG", "关闭监听 socket 失败");
            }
        }

        public void cancel() {
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                Log.e("TAG", "关闭监听 socket 失败");
            }
        }
    }

    // 连接线程
    private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;

        public ConnectThread(BluetoothDevice device) {
            BluetoothSocket tmp = null;
            mmDevice = device;

            // 创建连接 socket
            try {
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) {
                Log.e("TAG", "创建连接 socket 失败");
            }

            mmSocket = tmp;
        }

        public void run() {
            setName("ConnectThread");

            // 如果蓝牙设备还没被连接上，则开始连接
            mAdapter.cancelDiscovery();

            try {
                mmSocket.connect();
            } catch (IOException e) {
                try {
                    mmSocket.close();
                } catch (IOException e2) {
                }
                connectionFailed(); // 连接失败
                return;
            }

            // 连接成功，清空连接线程
            synchronized (T01_BluetoothSPP.this) {
                mConnectThread = null;
            }

            // 启动已连接线程
            connected(mmSocket, mmDevice);
        }

        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e("TAG", "关闭连接 socket 失败");
            }
        }
    }

    // 用于已连接线程
    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // 获取输入输出流
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            // 缓存区
            byte[] buffer = new byte[1024];
            int bytes;

            // 监听输入流
            while (true) {
                try {
                    // 从输入流读取数据
                    bytes = mmInStream.read(buffer);

                    // 将读入的数据送到处理程序
                    mHandler.obtainMessage(STATE_CONNECTING, bytes, -1, buffer).sendToTarget();
                } catch (IOException e) {
                    connectionLost(); // 连接丢失
                    break;
                }
            }
        }

        // 写出数据
        public void write(byte[] buffer) {
            try {
                mmOutStream.write(buffer);

                // 将输出缓存区的数据强制写出
                mmOutStream.flush();
            } catch (IOException e) {
            }
        }

        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
            }
        }
    }
}