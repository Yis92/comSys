package com.sixe.comSys.dto.QueryUserInfo;

import java.io.Serializable;

/**
 * Created by labiStronger on 2017/3/1.
 */
public class ComPanyParam implements Serializable{

    private String unit_no;//公司编号：注意，此编号唯一
    private String unit_name;//公司名

    public String getUnit_no() {
        return unit_no;
    }

    public void setUnit_no(String unit_no) {
        this.unit_no = unit_no;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }
}
