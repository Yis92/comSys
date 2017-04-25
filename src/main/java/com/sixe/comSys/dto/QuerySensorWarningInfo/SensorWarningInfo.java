package com.sixe.comSys.dto.QuerySensorWarningInfo;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/4/25-0025.
 */
public class SensorWarningInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String describ;
    private String data_no;
    private String up;
    private String low;
    private String lasting;
    private String interval;
    private String enable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getData_no() {
        return data_no;
    }

    public void setData_no(String data_no) {
        this.data_no = data_no;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getLasting() {
        return lasting;
    }

    public void setLasting(String lasting) {
        this.lasting = lasting;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}
