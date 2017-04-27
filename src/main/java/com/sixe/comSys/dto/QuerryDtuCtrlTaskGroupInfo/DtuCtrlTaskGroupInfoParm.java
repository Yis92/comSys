package com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo;

import com.sixe.comSys.dto.Result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dev3 on 2017/4/27-0027.
 */
public class DtuCtrlTaskGroupInfoParm implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<DtuCtrlTaskGroup> group;
    private Tskinfo tskinfo;

    public List<DtuCtrlTaskGroup> getGroup() {
        return group;
    }

    public void setGroup(List<DtuCtrlTaskGroup> group) {
        this.group = group;
    }

    public Tskinfo getTskinfo() {
        return tskinfo;
    }

    public void setTskinfo(Tskinfo tskinfo) {
        this.tskinfo = tskinfo;
    }
}
