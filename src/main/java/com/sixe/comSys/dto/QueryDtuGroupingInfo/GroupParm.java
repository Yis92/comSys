package com.sixe.comSys.dto.QueryDtuGroupingInfo;

import java.io.Serializable;

/**
 * Created by wuqiang on 2017/4/14-0014.
 */
public class GroupParm implements Serializable{
    private static final long serialVersionUID = 1L;

    private String group_id;
    private String name;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
