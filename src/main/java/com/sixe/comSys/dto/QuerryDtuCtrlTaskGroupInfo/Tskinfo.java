package com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dev3 on 2017/4/27-0027.
 */
public class Tskinfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String node_addr;
    private String tsk_num;
    private List<Tsk> tsk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNode_addr() {
        return node_addr;
    }

    public void setNode_addr(String node_addr) {
        this.node_addr = node_addr;
    }

    public String getTsk_num() {
        return tsk_num;
    }

    public void setTsk_num(String tsk_num) {
        this.tsk_num = tsk_num;
    }

    public List<Tsk> getTsk() {
        return tsk;
    }

    public void setTsk(List<Tsk> tsk) {
        this.tsk = tsk;
    }
}
