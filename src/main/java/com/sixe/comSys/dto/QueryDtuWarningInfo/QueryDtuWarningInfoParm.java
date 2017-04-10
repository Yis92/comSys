package com.sixe.comSys.dto.QueryDtuWarningInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/10-0010.
 */
public class QueryDtuWarningInfoParm extends Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<WarningInfo> result;

    public List<WarningInfo> getResult() {
        return result;
    }

    public void setResult(List<WarningInfo> result) {
        this.result = result;
    }
}
