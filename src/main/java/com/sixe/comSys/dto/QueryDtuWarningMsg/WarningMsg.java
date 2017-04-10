package com.sixe.comSys.dto.QueryDtuWarningMsg;

import java.io.Serializable;

/**
 * Created by dev3 on 2017/4/10-0010.
 */
public class WarningMsg implements Serializable{
    private static final long serialVersionUID = 1L;
    private String msgid;
    private String msg;     //报警说明
    private String tm;      //报警时间
    private String dispose;     //是否已经处理报警信息：0.未处理 1.已处理

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getDispose() {
        return dispose;
    }

    public void setDispose(String dispose) {
        this.dispose = dispose;
    }
}
