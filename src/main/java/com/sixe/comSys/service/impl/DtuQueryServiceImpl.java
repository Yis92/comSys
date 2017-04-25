package com.sixe.comSys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.dto.DataParm.QueryRealTimeData.QueryRealTimeDataParm;
import com.sixe.comSys.dto.QueryDtuCtrlNodeInfo.QueryDtuCtrlNodeInfoParam;
import com.sixe.comSys.dto.QueryDtuGroupDataInfo.QueryDtuGroupDataParm;
import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm;
import com.sixe.comSys.dto.QueryDtuWarningInfo.QueryDtuWarningInfoParm;
import com.sixe.comSys.dto.QueryDtuWarningMsg.QueryDtuWarningMsgParam;
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
            logger.info("【查询传感器节点信息】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_SENSOR_NODE_INFO, "UTF-8", map, 10000);
            logger.info("【查询传感器节点信息】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询传感器节点信息】请求成功");
                Gson gson = new Gson();
                QuerySensorNodeInfoParam param = gson.fromJson(result,QuerySensorNodeInfoParam.class);
                return param;
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

    /**
     * 查询报警信息
     * @param map
     * @return
     */
    public QueryDtuWarningInfoParm QueryDtuWarningInfo(Map<String, String> map) {
        String result;
        try{
            logger.info("【查询报警信息】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_SENSOR_WARNING_INFO, "UTF-8", map, 10000);
            logger.info("【查询报警信息】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询报警信息】请求成功");
                Gson gson = new Gson();
                QueryDtuWarningInfoParm param = gson.fromJson(result,QueryDtuWarningInfoParm.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询报警信息】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询报警消息
     * @param map
     */
    public QueryDtuWarningMsgParam QueryDtuWarningMsg(Map<String, String> map) {
        String result;
        try{
            logger.info("【查询报警消息】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_SENSOR_WARNING_MSG, "UTF-8", map, 10000);
            logger.info("【查询报警消息】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询报警消息】请求成功");
                Gson gson = new Gson();
                QueryDtuWarningMsgParam param = gson.fromJson(result,QueryDtuWarningMsgParam.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询报警消息】请求失败【message】:"+message);
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
            logger.info("【查询控制传感器节点信息】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_CTRL_NODE_TASK, "UTF-8", map, 10000);
            logger.info("【查询控制传感器节点信息】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询控制传感器节点信息】请求成功");
                Gson gson = new Gson();
                QueryDtuCtrlNodeInfoParam param = gson.fromJson(result,QueryDtuCtrlNodeInfoParam.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询控制传感器节点信息】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询分组显示信息
     * @param map
     * @return
     */
    public QueryDtuGroupingInfoParam QueryDtuGroupingInfo(Map<String, String> map) {
        String result;
        try{
            logger.info("【查询分组显示信息】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_GROUP_INFO, "UTF-8", map, 10000);
            logger.info("【查询分组显示信息】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询分组显示信息】请求成功");
                Gson gson = new Gson();
                QueryDtuGroupingInfoParam param = gson.fromJson(result,QueryDtuGroupingInfoParam.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询分组显示信息】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询DTU实时数据
     * @param map
     * @return
     */
    public QueryRealTimeDataParm QueryDtuDataDisplay(Map<String, String> map) {
        String result;
        try{
            logger.info("【查询DTU实时数据】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_REAL_DATA, "UTF-8", map, 10000);
            logger.info("【查询DTU实时数据】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询DTU实时数据】请求成功");
                Gson gson = new Gson();
                QueryRealTimeDataParm param = gson.fromJson(result,QueryRealTimeDataParm.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询DTU实时数据】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询DTU实时分组数据
     * @param map
     * @return
     */
    public QueryDtuGroupingInfoParam QueryDtuGroupingDataDisplay(Map<String, String> map) {
        String result;
        try{
            logger.info("【查询DTU实时分组数据】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_GROUP_DATA, "UTF-8", map, 10000);
            logger.info("【查询DTU实时分组数据】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询DTU实时分组数据】请求成功");
                Gson gson = new Gson();
                QueryDtuGroupingInfoParam param = gson.fromJson(result,QueryDtuGroupingInfoParam.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询DTU实时分组数据】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询DTU实时状态数据
     * @param map
     * @return
     */
    public QueryRealTimeDataParm QueryDtuStatusDataDisplay(Map<String, String> map) {
        String result;
        try{
            logger.info("【查询DTU实时状态数据】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_STATE, "UTF-8", map, 10000);
            logger.info("【查询DTU实时状态数据】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询DTU实时状态数据】请求成功");
                Gson gson = new Gson();
                QueryRealTimeDataParm param = gson.fromJson(result,QueryRealTimeDataParm.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询DTU实时状态数据】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询DTU历史数据
     * @param map
     * @return
     */
    public QueryDtuHisDataParm QueryDtuHisDataDisplay(Map<String, String> map) {
        String result;
        try{
            logger.info("【查询DTU历史数据】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_HISTORY_DATA, "UTF-8", map, 10000);
            logger.info("【查询DTU历史数据】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【查询DTU历史数据】请求成功");
                Gson gson = new Gson();

                QueryDtuHisDataParm param = gson.fromJson(result,QueryDtuHisDataParm.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【查询DTU历史数据】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询分组设置数据下拉框
     * @param map
     * @return
     */
    public QueryDtuGroupDataParm QueryDtuGroupDataInfo(Map<String, String> map) {
        String result;
        try{
            logger.info("【 查询分组设置数据下拉框】请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.QUERRY_DTU_GROUP_DATA_INFO, "UTF-8", map, 10000);
            logger.info("【 查询分组设置数据下拉框】返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("【 查询分组设置数据下拉框】请求成功");
                Gson gson = new Gson();
                QueryDtuGroupDataParm param = gson.fromJson(result,QueryDtuGroupDataParm.class);
                return param;
            }else{
                String message=jsonObj.getString("message");
                logger.info("【 查询分组设置数据下拉框】请求失败【message】:"+message);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}