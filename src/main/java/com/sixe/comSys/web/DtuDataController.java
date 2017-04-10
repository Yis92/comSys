package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
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

    /**
     * 获取分组信息
     * @param nodeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/groupingData",method = RequestMethod.POST)
    public String groupingData(String nodeId){
        /*logger.info("获取分组信息：【nodeId】:"+nodeId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        logger.info("请求参数："+map.toString());
        String result="";
       try{
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_GROUP_DATA_URL, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("请求成功");
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return Tools.sendJson("");
    }




}
