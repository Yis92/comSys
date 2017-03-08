package com.sixe.comSys.web;

import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wuqiang on 2017/3/8.
 */
@Controller
@RequestMapping(value = "/dtuData")
public class DtuDataController {

    private static final Logger logger = Logger.getLogger(DtuDataController.class);

    @ResponseBody
    @RequestMapping(value = "/groupingData",method = RequestMethod.POST)
    public String groupingData(String id){
        logger.info("获取分组信息：【id】:"+id);


        return "";
    }




}
