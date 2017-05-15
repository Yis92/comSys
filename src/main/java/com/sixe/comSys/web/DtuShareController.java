package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.dto.DataParm.QueryRealTimeData.QueryRealTimeDataParm;
import com.sixe.comSys.dto.QueryDtuGroupDataInfo.QueryDtuGroupDataParm;
import com.sixe.comSys.dto.QueryDtuGroupingInfo.QueryDtuGroupingInfoParam;
import com.sixe.comSys.dto.QueryDtuInfo.QueryDTUInfoParam;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.ProperUtils;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by dev3 on 2017/5/15-0015.
 * DTU分享的页面
 */
@Controller
@RequestMapping(value = "/dtuShare")
public class DtuShareController {

    private static final Logger logger = Logger.getLogger(DtuHomeController.class);
    @Autowired
    private DtuQueryService dtuQueryService;

    @RequestMapping(value = "goDataPage")
    public String goDataPage(String nodeId, String timeR, HttpServletRequest request, HttpServletResponse response){
        logger.info("DataPage【dtu_sn】:"+nodeId);
        request.setAttribute("dtu_sn",nodeId);
        request.setAttribute("timeR",timeR);
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
                return "/dtu/err/dtuErr";
            }
        }catch (Exception e){
            logger.info("http调用异常");
            e.printStackTrace();
            request.setAttribute("dtuInfo",null);
            return "/dtu/err/dtuErr";
        }
        logger.info("进入实时数据页面");
        //获取实时数据
        QueryRealTimeDataParm parm = dtuQueryService.QueryDtuDataDisplay(map);
        request.setAttribute("rtData",parm);
        return "/dtu/share/realTimeData";
    }

}
