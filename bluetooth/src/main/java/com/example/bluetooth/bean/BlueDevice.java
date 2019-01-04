package com.example.bluetooth.bean;

public class BlueDevice {//显示的设备信息
    public String name;//设备名
    public String address;//mac地址
    public int state;//当前状态

    public BlueDevice() {
        name = "";
        address = "";
        state = 0;
    }

    public BlueDevice(String name, String address, int state) {
        this.name = name;
        this.address = address;
        this.state = state;
    }
}
