package com.sixe.comSys.web;


import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.dto.QueryDtuHisData.HisDataParm;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm;
import com.sixe.comSys.dto.QuerySensorWarningInfo.QuerySensorWarningInfo;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
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
        //String [] timeData = {};
        List<String> timeData = new ArrayList<String>();

        List<String> data = new ArrayList<String>();
        //String [] data = {};
        String [] legendData = new String[1];
        String yAxisName = "";
        String seriesName = "";
        String yMax = "";
        String yMin = "";

        Map<String,Object> rtMap = new HashedMap();
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("data_no",pId);
        map.put("start_dt",startDate);
        map.put("end_dt",endDate);
        map.put("data_type",dataType);
        map.put("disp_type","1");
        logger.info("请求参数："+map.toString());
        QueryDtuHisDataParm parm = dtuQueryService.QueryDtuHisDataDisplay(map);
        if("200".equals(parm.getState())){
            yAxisName = parm.getResult().getyAxisName();
            seriesName = yAxisName +"("+parm.getResult().getUnitName()+")";
            legendData[0] = parm.getResult().getTitle();
            yMax = parm.getResult().getMax();
            yMin = parm.getResult().getMin();
            for(int i = 0;i<parm.getResult().getResult().size();i++){
                timeData.add(parm.getResult().getResult().get(i).getDate());
                data.add(parm.getResult().getResult().get(i).getValue());
            }
        }

        rtMap.put("timeData",timeData);
        rtMap.put("data",data);

        rtMap.put("legendData",legendData);
        rtMap.put("yAxisName",yAxisName);

        rtMap.put("seriesName",seriesName);
        rtMap.put("yMax",yMax);
        rtMap.put("yMin",yMin);
        rtMap.put("suc","SUC");

        System.out.println(rtMap.toString());
        return Tools.sendJson(rtMap);
    }

    @ResponseBody
    @RequestMapping(value = "/getSensorWarningInfo",method = RequestMethod.POST)
    public String getSensorWarningInfo(String nodeId,String dataNo){
        logger.info("获取单个要素报警信息：【nodeId】:"+nodeId+",【dataNo】:"+dataNo);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("data_no",dataNo);
        logger.info("请求参数："+map.toString());
        QuerySensorWarningInfo parm = dtuQueryService.querryDtuSensorWarningInfo2(map);
        return Tools.sendJson(parm.getResult());
    }

}
