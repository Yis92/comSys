package com.sixe.comSys.dto.QueryDtuWarningMsg;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dev3 on 2017/4/10-0010.
 */
public class QueryDtuWarningMsgParam extends Result implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<WarningMsg> result;

    public List<WarningMsg> getResult() {
        return result;
    }

    public void setResult(List<WarningMsg> result) {
        this.result = result;
    }
}
