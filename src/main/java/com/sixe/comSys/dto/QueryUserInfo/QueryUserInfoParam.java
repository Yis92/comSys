package com.sixe.comSys.dto.QueryUserInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;

/**
 * Created by labiStronger on 2017/3/1.
 */
public class QueryUserInfoParam extends Result implements Serializable {

    private UserInfoParam result;

    public UserInfoParam getResult() {
        return result;
    }

    public void setResult(UserInfoParam result) {
        this.result = result;
    }
}
