package com.sixe.comSys.dto.DoLogin;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/3/1.
 */
public class DoLoginParam extends Result implements Serializable{

    private UserParam result;//用户信息

    public UserParam getResult() {
        return result;
    }

    public void setResult(UserParam result) {
        this.result = result;
    }
}
