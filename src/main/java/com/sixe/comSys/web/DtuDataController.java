package com.sixe.comSys.web;


import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by wuqiang on 2017/3/8.
 */
@Controller
@RequestMapping(value = "/dtuData")
public class DtuDataController {

    private static final Logger logger = Logger.getLogger(DtuDataController.class);

    @Autowired
    private DtuQueryService dtuQueryService;
    /**
     * 获取分组信息
     * @param nodeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/groupingData",method = RequestMethod.POST)
    public String groupingData(String nodeId,String groupId){
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        //QueryDtuGroupingInfoParam groupInfo = dtuQueryService.QueryDtuGroupingInfo(map);
        map.put("group_id",groupId);
        logger.info("请求参数："+map.toString());
        QueryDtuGroupingInfoParam groupInfo = dtuQueryService.QueryDtuGroupingDataDisplay(map);
        return Tools.sendJson(groupInfo.getResult());
    }

    /**
     * 历史数据查询
     * @param dtu_sn
     * @param pId
     * @param startDate
     * @param endDate
     * @param dataType
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getHisData",method = RequestMethod.POST)
    public String getHisData(String dtu_sn,String pId,String startDate,String endDate,String dataType){
        Map<String,Object> rtMap = new HashedMap();
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("data_no",pId);
        map.put("start_dt",startDate);
        map.put("end_dt",endDate);
        map.put("data_type",dataType);
        logger.info("请求参数："+map.toString());
        Object o = dtuQueryService.QueryDtuHisDataDisplay(map);

        String [] timeData = {"2009/6/12 2:00", "2009/6/12 3:00", "2009/6/12 4:00", "2009/6/12 5:00", "2009/6/12 6:00", "2009/6/12 7:00", "2009/6/12 8:00", "2009/6/12 9:00", "2009/6/12 10:00", "2009/6/12 11:00"};
        String [] data = {"81", "16", "56", "-5", "-50", "-18", "2", "15", "59", "305"};
        String [] legendData = {"XXX（1）温度"};
        String yAxisName = "温度（°C）";
        String seriesName = "温度（°C）";
        String yMax = "400";
        String yMin = "-200";

        rtMap.put("timeData",timeData);
        rtMap.put("data",data);

        rtMap.put("legendData",legendData);
        rtMap.put("yAxisName",yAxisName);

        rtMap.put("seriesName",seriesName);
        rtMap.put("yMax",yMax);
        rtMap.put("yMin",yMin);
        rtMap.put("suc","SUC");
        return Tools.sendJson(rtMap);
    }

}
