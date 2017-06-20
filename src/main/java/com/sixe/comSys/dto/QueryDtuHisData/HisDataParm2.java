package com.sixe.comSys.dto.QueryDtuHisData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dev3 on 2017/4/21-0021.
 */
public class HisDataParm2 implements Serializable{
    private static final long serialVersionUID = 1L;
    private String date;
    private List<String> value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }
}
