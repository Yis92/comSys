package com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;

/**
 * Created by dev3 on 2017/4/27-0027.
 */
public class QuerryDtuCtrlTaskGroupInfoParm extends Result implements Serializable{

    private static final long serialVersionUID = 1L;
    private String dt;
    private DtuCtrlTaskGroupInfoParm result;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public DtuCtrlTaskGroupInfoParm getResult() {
        return result;
    }

    public void setResult(DtuCtrlTaskGroupInfoParm result) {
        this.result = result;
    }
}
