package com.sixe.comSys.dto.QueryCtrlNodeType;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dev3 on 2017/5/8-0008.
 */
public class QueryCtrlNodeTypeParm extends Result implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<List<Object>> result;

    public List<List<Object>> getResult() {
        return result;
    }

    public void setResult(List<List<Object>> result) {
        this.result = result;
    }
}
