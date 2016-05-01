package com.rokyinfo.convert;

/**
 * Created by YuanZhiJian on 16/5/1.
 */
public class DeviceInfo {

    @RkField(position = 0,length = 6)
    private String model;

    @RkField(position = 6,length = 2)
    private int versionCode;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }
}
