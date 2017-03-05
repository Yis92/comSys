package com.sixe.comSys.dto.QueryComInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/3/4.
 */
public class QueryComInfoParam extends Result implements Serializable{

    private ComInfoParam result;

    public ComInfoParam getResult() {
        return result;
    }

    public void setResult(ComInfoParam result) {
        this.result = result;
    }
}
