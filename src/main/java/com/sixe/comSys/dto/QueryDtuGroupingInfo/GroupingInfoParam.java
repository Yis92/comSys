package com.sixe.comSys.dto.QueryDtuGroupingInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/14-0014.
 */
public class GroupingInfoParam implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<GroupParm> group;
    private List<GroupDataParm> groupdata;

    public List<GroupParm> getGroup() {
        return group;
    }

    public void setGroup(List<GroupParm> group) {
        this.group = group;
    }

    public List<GroupDataParm> getGroupdata() {
        return groupdata;
    }

    public void setGroupdata(List<GroupDataParm> groupdata) {
        this.groupdata = groupdata;
    }
}
