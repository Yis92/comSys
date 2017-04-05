package com.sixe.comSys.service;

import com.sixe.comSys.dto.QueryDtuCtrlNodeInfo.QueryDtuCtrlNodeInfoParam;
import com.sixe.comSys.dto.QuerySensorNodeInfo.QuerySensorNodeInfoParam;

import java.util.Map;

/**
 * Created by wuqiang on 2017/3/31-0031.
 */
public interface DtuQueryService {
    /**
     * 查询传感器节点信息
     * @param map
     * @return
     */
    public QuerySensorNodeInfoParam querryDtuSensorNodeInfo(Map<String,String> map);

    /**
     * 查询控制传感器信息
     * @param map
     * @return
     */
    public QueryDtuCtrlNodeInfoParam queryDtuCtrlNodeInfo(Map<String,String> map);

    /**
     * 查询控
     * @param map
     * @param url
     * @param o
     * @return
     */

    public Object query(Map<String,String> map,String url,Object o);
}
