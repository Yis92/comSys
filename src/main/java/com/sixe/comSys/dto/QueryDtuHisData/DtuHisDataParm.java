package com.sixe.comSys.dto.QueryDtuHisData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuqiang on 2017/4/21-0021.
 */
public class DtuHisDataParm implements Serializable{

    private static final long serialVersionUID = 1L;
    private String title;           //标题
    private String yAxisName;       //y轴名称
    private String max;             //y轴最大值
    private String min;             //y轴最小值
    private String unitName;        //单位
    private List<HisDataParm> result;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getyAxisName() {
        return yAxisName;
    }

    public void setyAxisName(String yAxisName) {
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<HisDataParm> getResult() {
        return result;
    }

    public void setResult(List<HisDataParm> result) {
        this.result = result;
    }
}
