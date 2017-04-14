package com.sixe.comSys.dto.QueryDtuGroupingInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqiang on 2017/4/14-0014.
 */
public class QueryDtuGroupingInfoParam extends Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dt;
    private GroupingInfoParam result;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public GroupingInfoParam getResult() {
        return result;
    }

    public void setResult(GroupingInfoParam result) {
        this.result = result;
    }
}
