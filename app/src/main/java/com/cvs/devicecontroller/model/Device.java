package com.cvs.devicecontroller.model;

public class Device {
    private String deviceName;
    private boolean connected;

    public Device(String deviceName, boolean connected) {
        this.deviceName = deviceName;
        this.connected = connected;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}