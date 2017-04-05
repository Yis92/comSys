package com.sixe.comSys.dto.QueryDtuCtrlNodeInfo;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/4/5-0005.
 */
public class Tskdescrib implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tsk_channel;
    private String tsk_describ;

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
}
