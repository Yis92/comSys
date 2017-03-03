package com.sixe.comSys.dto.QueryUserList;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
public class QueryUserListParam extends Result implements Serializable{

    private List<UserParam> result;

    public List<UserParam> getResult() {
        return result;
    }

    public void setResult(List<UserParam> result) {
        this.result = result;
    }
}
