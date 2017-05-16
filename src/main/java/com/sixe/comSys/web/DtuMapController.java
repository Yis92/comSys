package com.sixe.comSys.web;


import com.google.gson.Gson;

import com.sixe.comSys.service.DtuMapService;

import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * dtu地图显示
 */
@Controller
@RequestMapping(value = "/map")
public class DtuMapController {

    private static final Logger logger = Logger.getLogger(DtuMapController.class);

    @Autowired
    private DtuMapService dtuMapService;
    /**
     * 获取dtu map
     * @param nodeId
     * @return
     */
    @RequestMapping(value = "/dtuMap")
    public String groupingData(String userId, Model model){
        Map<String,String> map = new HashedMap();
        map.put("user_id",userId);

        logger.info("请求参数："+map.toString());
        Map<String,Object> resultMap = dtuMapService.getDtuMap(map);
        Gson gson = new Gson();
        if(!resultMap.isEmpty()){//不为空
            logger.info("获取dtuMap正常");
            model.addAttribute("centerX",resultMap.get("centerX"));
            model.addAttribute("centerY",resultMap.get("centerY"));
            model.addAttribute("dtuList",gson.toJson(resultMap.get("dtuList")));
        } else {
            logger.info("获取dtuMap异常");
        }
        return "/map/dtuMap";
    }



}
