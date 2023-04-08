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



```java {.line-numbers}

```
