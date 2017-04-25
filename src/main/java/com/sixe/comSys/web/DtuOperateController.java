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

    /**
     * 删除分组信息
     * @param nodeId
     * @param groupId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delGroup.adv")
    public String delGroup(String nodeId,String groupId){
        logger.info("删除【nodeId】:"+nodeId+",【groupId】:"+groupId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("group_id",groupId);
        String result = dtuUpdateService.update(map,Contants.DEL_DTU_GROUP_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 新增分组数据
     * @param nodeId
     * @param aname1
     * @param asj1
     * @param asj2
     * @param asj3
     * @param asj4
     * @param asj5
     * @param asj6
     * @param asj7
     * @param asj8
     * @param asj9
     * @param asj10
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addGroup.adv")
    public String addGroup(String nodeId,String aname1,String asj1,String asj2,String asj3,String asj4,String asj5,String asj6,String asj7,String asj8,String asj9,String asj10){
        String [] arr = { asj1, asj2, asj3, asj4, asj5, asj6, asj7, asj8, asj9, asj10};
        System.out.println("asj:"+arr.toString());
        int i = 10 ;
        for (String s:arr){
            if("0".equals(s)){
                i--;
            }
        }
        logger.info("【新增】：");
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("group_describ",aname1);
        map.put("group_datanum",String.valueOf(i));
        map.put("group_datano1",asj1);
        map.put("group_datano2",asj2);
        map.put("group_datano3",asj3);
        map.put("group_datano4",asj4);
        map.put("group_datano5",asj5);
        map.put("group_datano6",asj6);
        map.put("group_datano7",asj7);
        map.put("group_datano8",asj8);
        map.put("group_datano9",asj9);
        map.put("group_datano10",asj10);
        String result = dtuUpdateService.update(map,Contants.ADD_DTU_GROUP_INFO);
        return Tools.sendJson(result);
    }

    /**
     * 修改dtu分组信息
     * @param nodeId
     * @param groupId
     * @param aname1
     * @param asj1
     * @param asj2
     * @param asj3
     * @param asj4
     * @param asj5
     * @param asj6
     * @param asj7
     * @param asj8
     * @param asj9
     * @param asj10
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updGroup.adv")
    public String updGroup(String nodeId,String groupId,String aname1,String asj1,String asj2,String asj3,String asj4,String asj5,String asj6,String asj7,String asj8,String asj9,String asj10){
        String [] arr = { asj1, asj2, asj3, asj4, asj5, asj6, asj7, asj8, asj9, asj10};
        System.out.println("asj:"+arr.toString());
        int i = 10 ;
        for (String s:arr){
            if("0".equals(s)){
                i--;
            }
        }
        logger.info("【新增】：");
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        map.put("group_describ",aname1);
        map.put("group_id",groupId);
        map.put("group_datanum",String.valueOf(i));
        map.put("group_datano1",asj1);
        map.put("group_datano2",asj2);
        map.put("group_datano3",asj3);
        map.put("group_datano4",asj4);
        map.put("group_datano5",asj5);
        map.put("group_datano6",asj6);
        map.put("group_datano7",asj7);
        map.put("group_datano8",asj8);
        map.put("group_datano9",asj9);
        map.put("group_datano10",asj10);
        String result = dtuUpdateService.update(map,Contants.UPDATE_DTU_GROUP_INFO);
        return Tools.sendJson(result);
    }

}
