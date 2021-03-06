package com.sixe.comSys.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.dto.DataParm.QueryRealTimeData.QueryRealTimeDataParm;
import com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo.QuerryDtuCtrlNodeTaskParm;
import com.sixe.comSys.dto.QuerryDtuCtrlTaskGroupInfo.QuerryDtuCtrlTaskGroupInfoParm;
import com.sixe.comSys.dto.QueryCtrlNodeType.QueryCtrlNodeTypeParm;
import com.sixe.comSys.dto.QueryDtuCtrlNodeInfo.QueryDtuCtrlNodeInfoParam;
import com.sixe.comSys.dto.QueryDtuGroupDataInfo.QueryDtuGroupDataParm;
import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.dto.QueryDtuInfo.QueryDTUInfoParam;
import com.sixe.comSys.dto.QueryDtuWarningMsg.QueryDtuWarningMsgParam;
import com.sixe.comSys.dto.QuerySensorNodeInfo.QuerySensorNodeInfoParam;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.service.DtuUpdateService;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sun.istack.internal.logging.Logger;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wuqiang on 2017/3/5.
 */
@Controller
@RequestMapping(value = "dtuHome")
public class DtuHomeController {

    private static final Logger logger = Logger.getLogger(DtuHomeController.class);

    @Autowired
    private DtuQueryService dtuQueryService;
    /**
     * DTU页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goDTUPage")
    public String goDTUPage(String nodeId,String type,HttpServletRequest request, HttpServletResponse response){
        logger.info("DTUPage【dtu_sn】:"+nodeId);
        request.setAttribute("dtu_sn",nodeId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.Query_Dtu_Info_Url, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                logger.info("查询成功...");
                Gson gson = new Gson();
                QueryDTUInfoParam param = gson.fromJson(result,QueryDTUInfoParam.class);
                request.setAttribute("dtuInfo",param.getResult());
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                request.setAttribute("dtuInfo",null);
            }
        }catch (Exception e){
            logger.info("http调用异常");
            e.printStackTrace();
            request.setAttribute("dtuInfo",null);
        }
        if("1".equals(type)){
            return "/com/dtuPage";
        }else if("2".equals(type)){//进入传感器节点信息页面
            QuerySensorNodeInfoParam parm = dtuQueryService.querryDtuSensorNodeInfo(map);
            QueryCtrlNodeTypeParm o = dtuQueryService.querryDtuSensorNodeType();
            request.setAttribute("types" ,o);
            request.setAttribute("sensorNodeInfo",parm);
            if(parm != null && parm.getResult() != null){
                request.setAttribute("size",parm.getResult().size());
            }else{
                request.setAttribute("size",0);
            }
            return "/dtu/sensorNodePage";
        }else if("3".equals(type)){//进入控制节点信息页面
            //获取控制节点信息
            QueryDtuCtrlNodeInfoParam parm = dtuQueryService.queryDtuCtrlNodeInfo(map);
            //获取控制节点类型码列表
            QueryCtrlNodeTypeParm types = dtuQueryService.QueryCtrlNodeType();
           // System.out.println("列表...."+types.toString());
            request.setAttribute("types" ,types);
            request.setAttribute("ctrlNodeInfo",parm);
            if(parm != null && parm.getResult() != null){
                request.setAttribute("size",parm.getResult().size());
            }else{
                request.setAttribute("size",0);
            }
            return "/dtu/controlNodePage";
        }else if("4".equals(type)){//进入报警信息页面
            QueryDtuWarningMsgParam parm = dtuQueryService.QueryDtuWarningMsg(map);
            request.setAttribute("warningMsg",parm);
            return "/dtu/warningPage";
        }else if("5".equals(type)){//进入分组信息页面
            Object o = dtuQueryService.QueryDtuGroupingInfo(map);
            Object o2 = dtuQueryService.QueryDtuDataDisplay(map);

            Object o3 = dtuQueryService.QueryDtuStatusDataDisplay(map);
            return "/dtu/groupingPage";
        }else if("6".equals(type)){//去数据显示页面
            return "/dtu/dataDisplayPage";
        }else if("7".equals(type)){//进入控制节点任务页面
            QuerryDtuCtrlTaskGroupInfoParm p = dtuQueryService.QuerryDtuCtrlTaskGroup_info(map);
            request.setAttribute("taskInfo",p);
            return "/dtu/controlNodeTaskPage";
        }
        return "/com/dtuPage";
    }

    /**
     * type:1.实时数据2.分组数据3.DTU状态
     * @param nodeId
     * @param type
     * @return
     */
    @RequestMapping(value = "/goDataPage")
    public String goDataPage(String nodeId,String type,String timeR,HttpServletRequest request, HttpServletResponse response){
        logger.info("DataPage【dtu_sn】:"+nodeId);
        request.setAttribute("dtu_sn",nodeId);
        request.setAttribute("timeR",timeR);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        logger.info("请求参数："+map.toString());
        if("1".equals(type)){//实时数据页面
            logger.info("进入实时数据页面");
            //获取实时数据
            QueryRealTimeDataParm parm = dtuQueryService.QueryDtuDataDisplay(map);
            request.setAttribute("rtData",parm);
            return "/dtu/data/realTimeData";
        }else if("2".equals(type)){//分组数据页面
            logger.info("进入分组数据页面");
            QueryDtuGroupDataParm odata = dtuQueryService.QueryDtuGroupDataInfo(map);
            QueryDtuGroupingInfoParam groupInfo = dtuQueryService.QueryDtuGroupingInfo(map);
            request.setAttribute("groupInfo",groupInfo);
            request.setAttribute("groupDataList",odata.getResult());
            return "/dtu/data/groupData";
        }else{//DTU状态页面
            logger.info("进入DTU状态数据页面");
            QueryRealTimeDataParm parm = dtuQueryService.QueryDtuStatusDataDisplay(map);
            request.setAttribute("dsData",parm);
            return "/dtu/data/dtuState";
        }
    }

    /**
     * 进入历史数据页面
     * @param nodeId
     * @param pId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goHisPage")
    public String goHisPage(String nodeId,String pId,String mType,HttpServletRequest request, HttpServletResponse response){
        logger.info("goHisPage【nodeId】:"+nodeId);
        logger.info("goHisPage【pId】:"+pId);
        request.setAttribute("dtu_sn",nodeId);
        request.setAttribute("pId",pId);

        //获取数据列表
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        logger.info("请求参数："+map.toString());
        QueryDtuGroupDataParm odata = dtuQueryService.QueryDtuGroupDataInfo(map);
        request.setAttribute("groupDataList",odata.getResult());
        if("APP".equals(mType)){
            return "/dtu/data/mhisData";
        }
        return "/dtu/data/hisData";
    }

    /**
     * 进入控制节点任务
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goTaskPage")
    public String goTaskPage(String nodeId,String nodeAddr,HttpServletRequest request, HttpServletResponse response){
        logger.info("goHisPage【nodeId】:"+nodeId);
        request.setAttribute("dtu_sn",nodeId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("node_addr",nodeAddr);
        logger.info("请求参数："+map.toString());
        QuerryDtuCtrlNodeTaskParm parm = dtuQueryService.QuerryDtuCtrlNodeTask(map);
        request.setAttribute("tsData",parm);
        return "/dtu/task/taskPage";
    }


}
