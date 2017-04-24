package com.sixe.comSys.web;

import com.google.gson.Gson;
import com.sixe.comSys.utils.InterfaceUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wuqiang on 2017/4/24-0024.
 */

@Controller
@RequestMapping(value = "/app")
public class AppUpdateController {

    /**
     * app版本
     * @return
     */
    @RequestMapping(value="version")
    public String getversion(){
        String appName= InterfaceUtil.getValue("config/common.properties","appName");
        String verCode= InterfaceUtil.getValue("config/common.properties","verCode");
        String verName= InterfaceUtil.getValue("config/common.properties","verName");
        String appUrl= InterfaceUtil.getValue("config/common.properties","appUrl");
        System.out.println("app版本");
        Map<String,Object> dataMap =new HashedMap();
        dataMap.put("appName",appName);
        dataMap.put("verCode",verCode);
        dataMap.put("verName",verName);
        dataMap.put("appUrl",appUrl);
        Map<String,Object>  resultMap =new HashedMap();
        resultMap.put("code","0");
        resultMap.put("message","获取成功");
        resultMap.putAll(dataMap);
        Gson gson = new Gson();
        String result = gson.toJson(resultMap);
        return result;
    }
}
