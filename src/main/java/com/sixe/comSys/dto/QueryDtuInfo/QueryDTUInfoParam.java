package com.sixe.comSys.dto.QueryDtuInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/3/29-0029.
 */
public class QueryDTUInfoParam extends Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private DTUInfo result;

    public DTUInfo getResult() {
        return result;
    }

    public void setResult(DTUInfo result) {
        this.result = result;
    }
}
