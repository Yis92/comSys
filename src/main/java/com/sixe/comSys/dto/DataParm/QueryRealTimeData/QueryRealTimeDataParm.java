package com.sixe.comSys.dto.DataParm.QueryRealTimeData;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * 实时数据Entity
 * Created by wuqiang on 2017/4/12-0012.
 */
public class QueryRealTimeDataParm extends Result implements Serializable{
    private static final long serialVersionUID = 1L;
    private String dt;
    private List<List<String>> result;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public List<List<String>> getResult() {
        return result;
    }

    public void setResult(List<List<String>> result) {
        this.result = result;
    }
}
