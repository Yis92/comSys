package com.sixe.comSys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.dto.QuerySensorNodeInfo.QuerySensorNodeInfoParam;
import com.sixe.comSys.service.DtuMapService;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lihaitao on 2017/5/16.
 */
@Service
public class DtuMapServiceImpl implements DtuMapService{
    private static final Logger logger = Logger.getLogger(DtuMapServiceImpl.class);
    public Map<String, Object> getDtuMap(Map<String, String> map) {

        Map<String,Object> resultMap = new HashMap<String, Object>();
        try{
            logger.info("【查询所有DTU地图】请求参数："+map.toString());
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_ALL_DTUS_WITH_MAP, "UTF-8", map, 10000);
            logger.info("【查询所有DTU地图】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询DTU地图信息】请求成功");
                JSONArray centerArray = jsonObj.getJSONObject("result").getJSONArray("center");
                if(centerArray.size() > 0){
                    resultMap.put("centerX",centerArray.getString(0));
                    resultMap.put("centerY",centerArray.getString(1));
                }
                JSONArray dtuArray = jsonObj.getJSONObject("result").getJSONArray("dutinfos");
                List<Map<String,String>> dtuList = new ArrayList<Map<String, String>>();
                for(int i=0;i<dtuArray.size();i++){
                    JSONObject dtuObj = dtuArray.getJSONObject(i);
                    Map<String,String> dtuMap = new HashMap<String, String>();
                    dtuMap.put("long",dtuObj.getString("long"));//经度
                    dtuMap.put("lat",dtuObj.getString("lat"));//纬度
                    dtuMap.put("name",dtuObj.getString("name"));//dut名字
                    dtuMap.put("info",dtuObj.getString("info"));//信息
                    dtuMap.put("state",dtuObj.getString("state"));//状态
                    dtuList.add(dtuMap);
                }
                resultMap.put("dtuList",dtuList);
                return resultMap;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询传感器节点信息】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
