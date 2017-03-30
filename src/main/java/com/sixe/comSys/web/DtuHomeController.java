package com.sixe.comSys.web;


import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wuqiang on 2017/3/5.
 */
@Controller
@RequestMapping(value = "dtuHome")
public class DtuHomeController {

    private static final Logger logger = Logger.getLogger(DtuHomeController.class);

    /**
     * 进入传感器节点信息页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goSensorNodePage")
    public String goSensorNodePage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("节点信息页面【nodeId】："+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/sensorNodePage";
    }

    /**
     * 进入控制节点信息页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goControlNodePage")
    public String goControlNodePage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("节点信息页面【nodeId】："+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/controlNodePage";
    }

    /**
     * 进入报警信息页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goWarningPage")
    public String goWarningPage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("进入报价信息页面【nodeId】"+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/warningPage";
    }

    /**
     * 去分组页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goGroupingPage")
    public String goGroupingPage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("进入分组页面【nodeId】"+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/groupingPage";
    }

    /**
     * 去数据显示页面
     *      。历史数据
     *      。站内节点地图方式
     *      。列表式 实时数据
     *      。分组式 实时数据
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goDataDisplayPage")
    public String goDataDisplayPage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("进入状态页面【nodeId】"+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/dataDisplayPage";
    }

}
