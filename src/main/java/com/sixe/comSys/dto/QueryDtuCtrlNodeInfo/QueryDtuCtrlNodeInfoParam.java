package com.sixe.comSys.dto.QueryDtuCtrlNodeInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/5-0005.
 */
public class QueryDtuCtrlNodeInfoParam extends Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CtrlNodeInfoParam> result;

    public List<CtrlNodeInfoParam> getResult() {
        return result;
    }

    public void setResult(List<CtrlNodeInfoParam> result) {
        this.result = result;
    }
}
