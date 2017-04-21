package com.sixe.comSys.dto.QueryDtuHisData;

import java.io.Serializable;

/**
 * Created by dev3 on 2017/4/21-0021.
 */
public class HisDataParm implements Serializable{
    private static final long serialVersionUID = 1L;
    private String date;
    private String value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
