package com.sixe.comSys.dto.DoLogin;

import java.io.Serializable;
import java.util.List;

/**
 * Created by labiStronger on 2017/3/1.
 */
public class ComParam implements Serializable{
    private String unit_no;//公司编号：注意，此编号唯一
    private String unit_name;//公司名
    private String dtu_num;//公司名下的dtu数量最大64个
    private List<DtuParam> dtu;//dtu列表

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

    public String getDtu_num() {
        return dtu_num;
    }

    public void setDtu_num(String dtu_num) {
        this.dtu_num = dtu_num;
    }

    public List<DtuParam> getDtu() {
        return dtu;
    }

    public void setDtu(List<DtuParam> dtu) {
        this.dtu = dtu;
    }
}
