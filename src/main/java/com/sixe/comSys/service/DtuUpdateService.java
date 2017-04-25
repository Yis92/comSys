package com.sixe.comSys.service;

import java.util.Map;

/**
 * Created by wuqiang on 2017/3/31-0031.
 */
public interface DtuUpdateService {

    /*修改DTU信息*/
    public String updDtuInfo(Map<String,String> map);
    /*修改DTU传感器节点信息*/
    public String updDtuSensorNodeInfo(Map<String,String> map);
    /*修改DTU控制节点信息*/
    public String updDtuCtrlNodeInfo(Map<String,String> map);
    /*按照url修改对应信息*/
    public String update(Map<String,String> map,String url);



}
