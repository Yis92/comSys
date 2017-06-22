package com.sixe.comSys.dto.QueryDtuHisData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/21-0021.
 */
public class DtuHisDataParm2 implements Serializable{

    private static final long serialVersionUID = 1L;
    private List<String> title;           //标题
    private List<String> yAxisName;       //y轴名称
    private String max;             //y轴最大值
    private String min;             //y轴最小值
    private List<String> unitName;        //单位
    private List<HisDataParm2> result;

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getyAxisName() {
        return yAxisName;
    }

    public void setyAxisName(List<String> yAxisName) {
        this.yAxisName = yAxisName;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public List<String> getUnitName() {
        return unitName;
    }

    public void setUnitName(List<String> unitName) {
        this.unitName = unitName;
    }

    public List<HisDataParm2> getResult() {
        return result;
    }

    public void setResult(List<HisDataParm2> result) {
        this.result = result;
    }
}
