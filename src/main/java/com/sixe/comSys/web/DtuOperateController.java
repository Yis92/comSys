package com.sixe.comSys.web;


import com.sixe.comSys.base.Contants;
import com.sixe.comSys.service.DtuUpdateService;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DtuUpdateService dtuUpdateService;
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
        String result= dtuUpdateService.updDtuInfo(map);
        logger.info("修改dtuInfo【result】"+result);
        return Tools.sendJson(result);
    }

    /**
     * 标记报警信息为已处理
     * @param dtu_sn
     * @param msgid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updWarningMsg")
    public String updWarningMsg(String dtu_sn,String msgid){
        logger.info("标记报警信息为已处理：【dtu_sn】"+dtu_sn);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",dtu_sn);
        map.put("msgid",msgid);
        String result = dtuUpdateService.update(map,Contants.DEAL_DTU_SENSOR_WARNING_MSG);
        return Tools.sendJson(result);
    }

}
