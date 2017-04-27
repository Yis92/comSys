package com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo;

import java.io.Serializable;

/**
 * Created by dev3 on 2017/4/27-0027.
 */
public class Tsk implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tsk_channel;
    private String tsk_describ;
    private String tsk_status;
    private String tsk_type;
    private String tsk_dt;
    private String tsk_tm;
    private String tsk_second;
    private String tsk_surplus;

    public String getTsk_channel() {
        return tsk_channel;
    }

    public void setTsk_channel(String tsk_channel) {
        this.tsk_channel = tsk_channel;
    }

    public String getTsk_describ() {
        return tsk_describ;
    }

    public void setTsk_describ(String tsk_describ) {
        this.tsk_describ = tsk_describ;
    }

    public String getTsk_status() {
        return tsk_status;
    }

    public void setTsk_status(String tsk_status) {
        this.tsk_status = tsk_status;
    }

    public String getTsk_type() {
        return tsk_type;
    }

    public void setTsk_type(String tsk_type) {
        this.tsk_type = tsk_type;
    }

    public String getTsk_dt() {
        return tsk_dt;
    }

    public void setTsk_dt(String tsk_dt) {
        this.tsk_dt = tsk_dt;
    }

    public String getTsk_tm() {
        return tsk_tm;
    }

    public void setTsk_tm(String tsk_tm) {
        this.tsk_tm = tsk_tm;
    }

    public String getTsk_second() {
        return tsk_second;
    }

    public void setTsk_second(String tsk_second) {
        this.tsk_second = tsk_second;
    }

    public String getTsk_surplus() {
        return tsk_surplus;
    }

    public void setTsk_surplus(String tsk_surplus) {
        this.tsk_surplus = tsk_surplus;
    }
}
