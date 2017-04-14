package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
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




}
