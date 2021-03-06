package com.sixe.comSys.service;

import com.sixe.comSys.dto.DataParm.QueryRealTimeData.QueryRealTimeDataParm;
import com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo.QuerryDtuCtrlNodeTaskParm;
import com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo.QuerryDtuCtrlTaskGroupInfoParm;
import com.sixe.comSys.dto.QueryCtrlNodeType.QueryCtrlNodeTypeParm;
import com.sixe.comSys.dto.QueryDtuCtrlNodeInfo.QueryDtuCtrlNodeInfoParam;
import com.sixe.comSys.dto.QueryDtuGroupDataInfo.QueryDtuGroupDataParm;
import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm2;
import com.sixe.comSys.dto.QueryDtuWarningInfo.QueryDtuWarningInfoParm;
import com.sixe.comSys.dto.QueryDtuWarningMsg.QueryDtuWarningMsgParam;
import com.sixe.comSys.dto.QuerySensorNodeInfo.QuerySensorNodeInfoParam;
import com.sixe.comSys.dto.QuerySensorWarningInfo.QuerySensorWarningInfo;

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
     * 查询传感器类型列表
     * @return
     */
    public QueryCtrlNodeTypeParm querryDtuSensorNodeType();

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

    public QueryDtuHisDataParm2 QueryDtuHisDataDisplay2(Map<String, String> map);

    /**
     * 查询分组下拉选项
     * @param map
     * @return
     */
    public QueryDtuGroupDataParm QueryDtuGroupDataInfo(Map<String,String> map);

    /**
     * 查询单个要素报警信息
     * @param map
     * @return
     */
    public QuerySensorWarningInfo querryDtuSensorWarningInfo2(Map<String,String> map);

    /**
     * 查询控制器分组信息
     * @param map
     * @return
     */
    public QuerryDtuCtrlTaskGroupInfoParm QuerryDtuCtrlTaskGroup_info(Map<String,String> map);

    /**
     *
     * @param map
     * @return
     */
    public QuerryDtuCtrlNodeTaskParm QuerryDtuCtrlNodeTask(Map<String,String> map);

    /**
     * 获取控制节点类型表
     * @return
     */
    public QueryCtrlNodeTypeParm QueryCtrlNodeType();

}
