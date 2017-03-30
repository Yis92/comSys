package com.sixe.comSys.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.dto.QueryDtuInfo.QueryDTUInfoParam;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wuqiang on 2017/3/5.
 */
@Controller
@RequestMapping(value = "dtuHome")
public class DtuHomeController {

    private static final Logger logger = Logger.getLogger(DtuHomeController.class);

    /**
     * DTU页面
     * @param nodeId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goDTUPage")
    public String goDTUPage(String nodeId,String type,HttpServletRequest request, HttpServletResponse response){
        logger.info("DTUPage【dtu_sn】:"+nodeId);
        request.setAttribute("dtu_sn",nodeId);
        Map<String,String> map = new HashedMap();
        map.put("dtu_sn",nodeId);
        logger.info("请求参数："+map.toString());
        try {
            String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl") + Contants.Query_Dtu_Info_Url, "UTF-8", map, 10000);
            logger.info("返回结果:" + result);
            JSONObject jsonObj = JSON.parseObject(result);
            String state=jsonObj.getString("state");
            if("200".equals(state)){
                logger.info("查询成功...");
                Gson gson = new Gson();
                QueryDTUInfoParam param = gson.fromJson(result,QueryDTUInfoParam.class);
                request.setAttribute("dtuInfo",param.getResult());
            }else{
                String message=jsonObj.getString("message");
                logger.info("请求失败【message】:"+message);
                request.setAttribute("dtuInfo",null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if("1".equals(type)){
            return "/com/dtuPage";
        }else if("2".equals(type)){//进入传感器节点信息页面
            return "/dtu/sensorNodePage";
        }else if("3".equals(type)){//进入控制节点信息页面
            return "/dtu/controlNodePage";
        }else if("4".equals(type)){//进入报警信息页面
            return "/dtu/warningPage";
        }else if("5".equals(type)){//进入分组信息页面
            return "/dtu/groupingPage";
        }else if("6".equals(type)){//去数据显示页面
            return "/dtu/dataDisplayPage";
        }
        return "/com/dtuPage";
    }

}
