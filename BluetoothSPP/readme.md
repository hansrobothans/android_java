# 项目简介
学习[mooc](https://www.icourse163.org/learn/JSSVC-1449806164)中章节中蓝牙小车的例程。  
理清各个步骤，并实现初步蓝牙SPP聊天框  
# 版本说明
## V1.0.0
空白工程  

## V1.0.1.（可运行）  
###  V1.0.1.1. 实现移植（除语音识别）注释掉语音识别相关部分  
语音识别直接不复制，然后对mainActivity中涉及mainActivity相关的进行注释  
###  V1.0.1.2. 对BluetoothDeviceListActivity文件中报错的进行处理（即增加if权限判断）

```java {.line-numbers}
if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
    // TODO: Consider calling
    //    ActivityCompat#requestPermissions
    // here to request the missing permissions, and then overriding
    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
    //                                          int[] grantResults)
    // to handle the case where the user grants the permission. See the documentation
    // for ActivityCompat#requestPermissions for more details.
//                    return;
    Toast.makeText(getApplicationContext(), "行号", Toast.LENGTH_SHORT).show();
}
```

###  V1.0.1.3. 对连接蓝牙报错闪退问题进行处理（Android12以上，需要动态申请权限）
[解决原因参考](https://blog.csdn.net/chuyouyinghe/article/details/124583492)  
[解决办法参考](https://stackoverflow.com/questions/70245463/java-lang-securityexception-need-android-permission-bluetooth-connect-permissio)
#### 解决办法参考
您应该在 Manifest 和 Activity.java 中声明 BLUETOOTH_SCAN 和权限
1. AndroiManifest.xml
例如：
```xml {.line-numbers}
<uses-permission android:name="android.permission.BLUETOOTH"
   android:maxSdkVersion="30" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN"
   android:maxSdkVersion="30" />
<!-- Needed only if your app looks for Bluetooth devices. -->
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"/>
<uses-permission android:name="android.permission.BLUETOOTH_PRIVILEGED"
   tools:ignore="ProtectedPermissions" />
```

2. MainActivity.java
```java {.line-numbers}
private static String[] PERMISSIONS_STORAGE = {
   Manifest.permission.READ_EXTERNAL_STORAGE,
   Manifest.permission.WRITE_EXTERNAL_STORAGE,
   Manifest.permission.ACCESS_FINE_LOCATION,
   Manifest.permission.ACCESS_COARSE_LOCATION,
   Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
   Manifest.permission.BLUETOOTH_SCAN,
   Manifest.permission.BLUETOOTH_CONNECT,
   Manifest.permission.BLUETOOTH_PRIVILEGED
};
private static String[] PERMISSIONS_LOCATION = {
   Manifest.permission.ACCESS_FINE_LOCATION,
   Manifest.permission.ACCESS_COARSE_LOCATION,
   Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
   Manifest.permission.BLUETOOTH_SCAN,
   Manifest.permission.BLUETOOTH_CONNECT,
   Manifest.permission.BLUETOOTH_PRIVILEGED
};
```
和  
```java {.line-numbers}
private void checkPermissions(){
   int permission1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
   int permission2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN);
   if (permission1 != PackageManager.PERMISSION_GRANTED) {
         // We don't have permission so prompt the user
         ActivityCompat.requestPermissions(
         this,
         PERMISSIONS_STORAGE,
         1
      );
   } else if (permission2 != PackageManager.PERMISSION_GRANTED){
         ActivityCompat.requestPermissions(
         this,
         PERMISSIONS_LOCATION,
         1
      );
   }
}
```
## V1.0.2
基于空白工程移植BlueCar工程代码
实现功能：
1. 初步解决权限报错问题
2. 现在卡在蓝牙扫描上面

## V1.1.0
移植BLESerial
复制文件
1. 增加color.xml()
```xml {.line-numbers}
<color name="colorPrimary">#F97ABD9A</color>
<color name="colorPrimaryDark">#F97ABD9A</color>
<color name="colorAccent">#F97ABD9A</color>
```
2. 复制style.xml
3. 复制activity_main.xml
4. 增加AndroidManifest.xml
```xml {.line-numbers}
<uses-permission android:name="android.permission.BLUETOOTH"
        android:maxSdkVersion="30" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN"
        android:maxSdkVersion="30" />
    <!-- Needed only if your app looks for Bluetooth devices. -->
    <uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
    <uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"/>
    <uses-permission android:name="android.permission.BLUETOOTH_PRIVILEGED"
        tools:ignore="ProtectedPermissions" />
```  
5. 修改主题AndroidManifest.xml
```xml {.line-numbers}
android:theme="@style/AppTheme"
```
6. 复制并修改MainActivity.java
   1. 完全复制
   2. 复制后修改错误提示（增加显示权限检查四处）
```java {.line-numbers}
if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

}
```  
7. 复制并修改BLESPPUtils
   1. 完全复制
   2. 复制后新增成员变量并修改构造函数
```java {.line-numbers}
private static Context mContext;
BLESPPUtils(Context context, OnBluetoothAction onBluetoothAction) {
        mContext = context;
        mOnBluetoothAction = onBluetoothAction;
    }
```
   3. 修改MainActivity.java构造调用，传入对应参数
```java {.line-numbers}
// 初始化
mBLESPPUtils = new BLESPPUtils(this, this);
```  
   4. 修改错误提示（增加显示权限检查七处）
```java {.line-numbers}
if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

}
```    
此时可以正常编译，但是运行时不正常，会一直屏幕闪烁，然后过段时间强退
### 问题一：正常编译，但是运行时不正常，会一直屏幕闪烁，然后过段时间强退
现象：正常编译，但是运行时不正常，会一直屏幕闪烁，然后过段时间强退
问题；没有动态申请权限
[解决办法参考](https://stackoverflow.com/questions/70245463/java-lang-securityexception-need-android-permission-bluetooth-connect-permissio)
问题解决：
1.修改initPermission方法
```java {.line-numbers}
 /**
     * 申请运行时权限，不授予会搜索不到设备
     */
    private void initPermissions() {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_CONNECT,
                Manifest.permission.BLUETOOTH_PRIVILEGED
        };
        String[] PERMISSIONS_LOCATION = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                Manifest.permission.BLUETOOTH_SCAN,
                Manifest.permission.BLUETOOTH_CONNECT,
                Manifest.permission.BLUETOOTH_PRIVILEGED
        };
        int permission1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permission2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN);
        if (permission1 != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    1
            );
        } else if (permission2 != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_LOCATION,
                    1
            );
        }
//        if (ContextCompat.checkSelfPermission(this, "android.permission-group.LOCATION") != 0) {
//            ActivityCompat.requestPermissions(
//                    this,
//                    new String[]{
//                            "android.permission.ACCESS_FINE_LOCATION",
//                            "android.permission.ACCESS_COARSE_LOCATION",
//                            "android.permission.ACCESS_WIFI_STATE"},
//                    1
//            );
//        }
    }

```
2. 在DeviceDialogCtrl类show方法第一行显示调用

## V1.1.1
修改一些注释

## V1.1.2
采用listView的方式刷新蓝夜列表，连接并接收数据





```java {.line-numbers}

```
