package com.sixe.comSys.dto.QuerySensorWarningInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/4/25-0025.
 */
public class QuerySensorWarningInfo extends Result implements Serializable{

    private static final long serialVersionUID = 1L;
    private SensorWarningInfo result;

    public SensorWarningInfo getResult() {
        return result;
    }

    public void setResult(SensorWarningInfo result) {
        this.result = result;
    }
}
