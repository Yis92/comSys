package com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo;

import java.io.Serializable;

/**
 * Created by dev3 on 2017/4/27-0027.
 */
public class DtuCtrlNodeTaskParm implements Serializable{
    private static final long serialVersionUID = 1L;
    private Tskinfo tskinfo;

    public Tskinfo getTskinfo() {
        return tskinfo;
    }

    public void setTskinfo(Tskinfo tskinfo) {
        this.tskinfo = tskinfo;
    }
}
