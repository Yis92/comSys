package com.sixe.comSys.dto;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/3/1.
 */
public class Result implements Serializable{

    private String state;

    private String message;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
