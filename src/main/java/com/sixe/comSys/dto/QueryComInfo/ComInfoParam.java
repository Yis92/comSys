package com.sixe.comSys.dto.QueryComInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/3/4.
 */
public class ComInfoParam implements Serializable{
    private String unit_no;//公司编号：注意，此编号唯一
    private String unit_name;//公司名
    private String unit_long;
    private String unit_lat;
    private String address;
    private String unit_tel1;
    private String unit_tel2;
    private String unit_tel3;
    private String unit_tel4;
    private String unit_tel5;
    private String unit_tel6;
    private String dtu_num;
    private List<DtuParam> dtu;

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

    public String getUnit_long() {
        return unit_long;
    }

    public void setUnit_long(String unit_long) {
        this.unit_long = unit_long;
    }

    public String getUnit_lat() {
        return unit_lat;
    }

    public void setUnit_lat(String unit_lat) {
        this.unit_lat = unit_lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUnit_tel1() {
        return unit_tel1;
    }

    public void setUnit_tel1(String unit_tel1) {
        this.unit_tel1 = unit_tel1;
    }

    public String getUnit_tel2() {
        return unit_tel2;
    }

    public void setUnit_tel2(String unit_tel2) {
        this.unit_tel2 = unit_tel2;
    }

    public String getUnit_tel3() {
        return unit_tel3;
    }

    public void setUnit_tel3(String unit_tel3) {
        this.unit_tel3 = unit_tel3;
    }

    public String getUnit_tel4() {
        return unit_tel4;
    }

    public void setUnit_tel4(String unit_tel4) {
        this.unit_tel4 = unit_tel4;
    }

    public String getUnit_tel5() {
        return unit_tel5;
    }

    public void setUnit_tel5(String unit_tel5) {
        this.unit_tel5 = unit_tel5;
    }

    public String getUnit_tel6() {
        return unit_tel6;
    }

    public void setUnit_tel6(String unit_tel6) {
        this.unit_tel6 = unit_tel6;
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
