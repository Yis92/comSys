package com.sixe.comSys.dto.QueryDtuHisData;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/21-0021.
 */
public class QueryDtuHisDataParm extends Result implements Serializable{
    private static final long serialVersionUID = 1L;
    private DtuHisDataParm result;

    public DtuHisDataParm getResult() {
        return result;
    }

    public void setResult(DtuHisDataParm result) {
        this.result = result;
    }
}
