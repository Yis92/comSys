package com.sixe.comSys.dto.QueryDtuHisData;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/21-0021.
 */
public class QueryDtuHisDataParm2 extends Result implements Serializable{
    private static final long serialVersionUID = 1L;
    private DtuHisDataParm2 result;

    public DtuHisDataParm2 getResult() {
        return result;
    }

    public void setResult(DtuHisDataParm2 result) {
        this.result = result;
    }
}
