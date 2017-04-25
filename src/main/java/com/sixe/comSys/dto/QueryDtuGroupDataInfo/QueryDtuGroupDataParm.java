package com.sixe.comSys.dto.QueryDtuGroupDataInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/25-0025.
 */
public class QueryDtuGroupDataParm extends Result implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<GroupDataInfo> result;

    public List<GroupDataInfo> getResult() {
        return result;
    }

    public void setResult(List<GroupDataInfo> result) {
        this.result = result;
    }
}
