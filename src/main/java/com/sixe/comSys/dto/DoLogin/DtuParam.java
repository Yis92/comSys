package com.sixe.comSys.dto.DoLogin;

import java.io.Serializable;

/**
 * Created by labiStronger on 2017/3/1.
 */
public class DtuParam implements Serializable{

    private String dtu1_name;//dtu名字
    private String dtu1_sn;//dtu编号

    public String getDtu1_name() {
        return dtu1_name;
    }

    public void setDtu1_name(String dtu1_name) {
        this.dtu1_name = dtu1_name;
    }

    public String getDtu1_sn() {
        return dtu1_sn;
    }

    public void setDtu1_sn(String dtu1_sn) {
        this.dtu1_sn = dtu1_sn;
    }
}
