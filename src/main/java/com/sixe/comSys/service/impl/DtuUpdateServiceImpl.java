package com.sixe.comSys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.service.DtuUpdateService;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wuqiang on 2017/3/31-0031.
 */
@Service
public class DtuUpdateServiceImpl implements DtuUpdateService {

    private static final Logger logger = Logger.getLogger(DtuUpdateServiceImpl.class);

    /**
     * 修改dtu信息
     * @param map
     * @return
     */
    public String updDtuInfo(Map<String, String> map) {
        String result;
        try{//修改dtu信息
            logger.info("请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.Update_Dtu_Info_Url, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("请求成功");
                return "SUC";
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return message;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "接口服务异常";
        }
    }

    /**
     * 修改DTU传感器节点信息
     * @param map
     * @return
     */
    public String updDtuSensorNodeInfo(Map<String, String> map) {
        return null;
    }

    /**
     * 修改DTU控制节点信息
     * @param map
     * @return
     */
    public String updDtuCtrlNodeInfo(Map<String, String> map) {
        return null;
    }

    /**
     * 按照url修改对应信息
     * @param map
     * @param url
     * @return
     */
    public String update(Map<String, String> map, String url) {
        String result;
        try{//修改dtu信息
            logger.info("请求参数："+map.toString());
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + url, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("请求成功");
                return "SUC";
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return message;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "接口服务异常";
        }
    }
}
