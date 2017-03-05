package com.sixe.comSys.dto.DoLogin;

import java.io.Serializable;

/**
 * Created by labiStronger on 2017/3/1.
 */
public class DtuParam implements Serializable{

    private String dtu_name;//dtu名字
    private String dtu_sn;//dtu编号

    public String getDtu_name() {
        return dtu_name;
    }

    public void setDtu_name(String dtu_name) {
        this.dtu_name = dtu_name;
    }

    public String getDtu_sn() {
        return dtu_sn;
    }

    public void setDtu_sn(String dtu_sn) {
        this.dtu_sn = dtu_sn;
    }
}
