package com.sixe.comSys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.dto.QueryDtuCtrlNodeInfo.QueryDtuCtrlNodeInfoParam;
import com.sixe.comSys.dto.QuerySensorNodeInfo.QuerySensorNodeInfoParam;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wuqiang on 2017/3/31-0031.
 */
@Service
public class DtuQueryServiceImpl implements DtuQueryService {
    private static final Logger logger = Logger.getLogger(DtuQueryServiceImpl.class);

    public QuerySensorNodeInfoParam querryDtuSensorNodeInfo(Map<String, String> map) {
        String result;
        try{
            logger.info("请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_SENSOR_NODE_INFO, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("请求成功");
                Gson gson = new Gson();
                QuerySensorNodeInfoParam param = gson.fromJson(result,QuerySensorNodeInfoParam.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询控制传感器节点信息
     * @param map
     * @return
     */
    public QueryDtuCtrlNodeInfoParam queryDtuCtrlNodeInfo(Map<String, String> map) {
        String result;
        try{
            logger.info("请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_CTRL_NODE_TASK, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("请求成功");
                Gson gson = new Gson();
                QueryDtuCtrlNodeInfoParam param = gson.fromJson(result,QueryDtuCtrlNodeInfoParam.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Object query(Map<String, String> map,String url, Object o) {
        String result;
        try{//修改dtu信息
            logger.info("请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + url, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("请求成功");
                Gson gson = new Gson();
                Object param = gson.fromJson(result,Object.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}