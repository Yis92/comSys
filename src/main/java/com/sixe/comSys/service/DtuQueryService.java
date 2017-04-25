package com.sixe.comSys.service;

import com.sixe.comSys.dto.DataParm.QueryRealTimeData.QueryRealTimeDataParm;
import com.sixe.comSys.dto.QueryDtuCtrlNodeInfo.QueryDtuCtrlNodeInfoParam;
import com.sixe.comSys.dto.QueryDtuGroupDataInfo.QueryDtuGroupDataParm;
import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm;
import com.sixe.comSys.dto.QueryDtuWarningInfo.QueryDtuWarningInfoParm;
import com.sixe.comSys.dto.QueryDtuWarningMsg.QueryDtuWarningMsgParam;
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
     * 查询报警信息
     * @param map
     * @return
     */
    public QueryDtuWarningInfoParm QueryDtuWarningInfo(Map<String,String> map);

    /**
     * 查询报警消息
     * @param map
     */
    public QueryDtuWarningMsgParam QueryDtuWarningMsg(Map<String,String> map);

    /**
     * 查询分组显示信息
     * @param map
     * @return
     */
    public QueryDtuGroupingInfoParam QueryDtuGroupingInfo(Map<String,String> map);

    /**
     * 查询DTU实时数据
     * @param map
     * @return
     */
    public QueryRealTimeDataParm QueryDtuDataDisplay(Map<String,String> map);

    /**
     * 查询DTU实时分组数据
     * @param map
     * @return
     */
    public QueryDtuGroupingInfoParam QueryDtuGroupingDataDisplay(Map<String,String> map);

    /**
     * 查询DTU实时状态数据
     * @param map
     * @return
     */
    public QueryRealTimeDataParm QueryDtuStatusDataDisplay(Map<String,String> map);

    /**
     * 查询DTU历史数据
     * @param map
     * @return
     */
    public QueryDtuHisDataParm QueryDtuHisDataDisplay(Map<String,String> map);

    /**
     *
     * @param map
     * @return
     */
    public QueryDtuGroupDataParm QueryDtuGroupDataInfo(Map<String,String> map);
}
