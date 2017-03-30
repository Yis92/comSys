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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * dtu修改操作
 * Created by wuqiang on 2017/3/30-0030.
 */
@Controller
@RequestMapping(value = "/dtuOperate")
public class DtuOperateController {

    private static final Logger logger = Logger.getLogger(DtuOperateController.class);

    /**
     * 修改DTUinfo
     * @param dtu_sn
     * @param dtu_name
     * @param dtu_describ
     * @param dtu_address
     * @param dtu_long
     * @param dtu_lat
     * @param dtu_comm_type
     * @param dtu_upfreq
     * @param dtu_warning_type
     * @param dtu_sim_no
     * @param dtu_type
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updDtuInfo.adv")
    public String updDtuInfo(String dtu_sn,String dtu_name,String dtu_describ,String  dtu_address,String dtu_long,
                            String dtu_lat,String dtu_comm_type,String dtu_upfreq,String dtu_warning_type,String dtu_sim_no,String dtu_type){
        logger.info("修改dtuInfo【dtu_sn】"+dtu_sn);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("dtu_name",dtu_name);
        map.put("dtu_describ",dtu_describ);
        map.put("dtu_address",dtu_address);
        map.put("dtu_long",dtu_long);
        map.put("dtu_lat",dtu_lat);
        map.put("dtu_comm_type",dtu_comm_type);
        map.put("dtu_upfreq",dtu_upfreq);
        map.put("dtu_warning_type",dtu_warning_type);
        map.put("dtu_sim_no",dtu_sim_no);
        map.put("dtu_type",dtu_type);
        logger.info("请求参数："+map.toString());
        String result="";
        try{//修改dtu信息
            result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.Update_Dtu_Info_Url, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)) {
                logger.info("请求成功");
                return Tools.sendJson("SUC");
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                return Tools.sendJson(message);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Tools.sendJson("接口服务异常");
        }
    }

}
