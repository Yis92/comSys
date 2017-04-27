package com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo;

import java.io.Serializable;

/**
 * Created by dev3 on 2017/4/27-0027.
 */
public class DtuCtrlTaskGroup implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String group_id;
    private String node_addr;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getNode_addr() {
        return node_addr;
    }

    public void setNode_addr(String node_addr) {
        this.node_addr = node_addr;
    }
}
