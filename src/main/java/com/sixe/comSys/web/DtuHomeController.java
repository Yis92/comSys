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
     * 进入节点信息页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goNodePage")
    public String goNodePage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("节点信息页面【nodeId】："+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/nodePage";
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
     * 去状态页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goStatusPage")
    public String goStatusPage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("进入状态页面【nodeId】"+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/ststusPage";
    }

    /**
     * 历史数据页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goHistoryPage")
    public String goHistoryPage(String nodeId, HttpServletRequest request, HttpServletResponse response){
        logger.info("进入历史数据页面【nodeId】"+nodeId);
        request.setAttribute("nodeId",nodeId);
        return "/dtu/historyPage";
    }
}
