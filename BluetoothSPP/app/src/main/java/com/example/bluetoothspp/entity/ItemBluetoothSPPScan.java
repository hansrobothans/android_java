package com.example.bluetoothspp.entity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;

public class ItemBluetoothSPPScan {
    private String name;
    private String address;
    private BluetoothDevice mDevice;

    public ItemBluetoothSPPScan() {
    }

    @SuppressLint("MissingPermission")
    public ItemBluetoothSPPScan(BluetoothDevice mDevice) {
        this.mDevice = mDevice;
        this.name = mDevice.getName();
        this.address = mDevice.getAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BluetoothDevice getDevice() {
        return mDevice;
    }

    @SuppressLint("MissingPermission")
    public void setDevice(BluetoothDevice mDevice) {
        this.mDevice = mDevice;
        this.name = mDevice.getName();
        this.address = mDevice.getAddress();
    }


}