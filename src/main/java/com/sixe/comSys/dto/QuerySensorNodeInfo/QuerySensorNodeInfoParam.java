package com.sixe.comSys.dto.QuerySensorNodeInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/5-0005.
 */
public class QuerySensorNodeInfoParam extends Result implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<SensorNodeInfoParam> result ;

    public List<SensorNodeInfoParam> getResult() {
        return result;
    }

    public void setResult(List<SensorNodeInfoParam> result) {
        this.result = result;
    }


}
