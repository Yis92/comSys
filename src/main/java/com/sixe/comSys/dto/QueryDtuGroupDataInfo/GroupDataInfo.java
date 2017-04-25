package com.sixe.comSys.dto.QueryDtuGroupDataInfo;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/4/25-0025.
 */
public class GroupDataInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
