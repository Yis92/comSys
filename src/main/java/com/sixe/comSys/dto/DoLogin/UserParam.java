package com.sixe.comSys.dto.DoLogin;

import java.io.Serializable;
import java.util.List;

/**
 * Created by labiStronger on 2017/3/1.
 */
public class UserParam implements Serializable {
    private String user_id;//用户id
    private int user_level;//用户等级，其中，10：公司管理员，11：高级用户，12：普通用户
    private String unit_num;//关联公司个数，最大10个
    private List<ComParam> units;//公司列表

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    public String getUnit_num() {
        return unit_num;
    }

    public void setUnit_num(String unit_num) {
        this.unit_num = unit_num;
    }

    public List<ComParam> getUnits() {
        return units;
    }

    public void setUnits(List<ComParam> units) {
        this.units = units;
    }
}
