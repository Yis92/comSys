package com.sixe.comSys.dto.QuerySensorNodeInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqiang on 2017/4/5-0005.
 */
public class SensorNodeInfoParam implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;        //传感器名字
    private String cfg;         //传感器类型码-可以不显示出来-但在设置的时候需要带入
    private String addr;        //传感器地址
    private String describ;     //传感器描述
    private String x;           //站内坐标X
    private String y;           //站内坐标Y

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCfg() {
        return cfg;
    }

    public void setCfg(String cfg) {
        this.cfg = cfg;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
