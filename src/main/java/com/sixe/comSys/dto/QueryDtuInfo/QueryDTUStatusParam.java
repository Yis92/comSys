package com.sixe.comSys.dto.QueryDtuInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wuqiang on 2017/3/5.
 */
public class QueryDTUStatusParam extends Result implements Serializable{
    private Date dt;
    private List<String[]> result;
    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public List<String[]> getResult() {
        return result;
    }

    public void setResult(List<String[]> result) {
        this.result = result;
    }
}
