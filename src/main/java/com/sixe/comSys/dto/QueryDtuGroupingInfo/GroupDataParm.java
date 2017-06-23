package com.sixe.comSys.dto.QueryDtuGroupingInfo;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/4/14-0014.
 */
public class GroupDataParm implements Serializable{
    private static final long serialVersionUID = 1L;
    private String value;
    private String name;
    private String unit;
    private String max;
    private String mini;
    private String id;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMini() {
        return mini;
    }

    public void setMini(String mini) {
        this.mini = mini;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
