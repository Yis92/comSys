package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.Contants;
import com.sixe.comSys.base.SpringContextHolder;
import com.sixe.comSys.base.imgCode.ValidateCode;
import com.sixe.comSys.dto.DoLogin.DoLoginParam;
import com.sixe.comSys.dto.QueryDtuGroupDataInfo.QueryDtuGroupDataParm;
import com.sixe.comSys.dto.QueryDtuHisData.QueryDtuHisDataParm;
import com.sixe.comSys.service.DtuQueryService;
import com.sixe.comSys.utils.BatchExport;
import com.sixe.comSys.utils.HttpTools;
import com.sixe.comSys.utils.ProperUtils;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by labiStronger on 2017/2/24.
 */
@Controller
@RequestMapping(value = "/home")
public class ExportController {

    private static final Logger logger = Logger.getLogger(ExportController.class);

    @Autowired
    private DtuQueryService dtuQueryService;
    /**
     * 测试导入.
     * @return
     */
    @RequestMapping(value="export")
    public void login(HttpServletResponse response){
        logger.info("开始导出数据...");
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> parm1 = new HashedMap();
        parm1.put("id","1");
        parm1.put("name","张三");
        parm1.put("phone","1231351313");
        parm1.put("email","113131@qq.com");
        Map<String,Object> parm2 = new HashedMap();
        parm2.put("id","1");
        parm2.put("name","张三");
        parm2.put("phone","1231351313");
        parm2.put("email","113131@qq.com");
        Map<String,Object> parm3 = new HashedMap();
        parm3.put("id","1");
        parm3.put("name","张三");
        parm3.put("phone","1231351313");
        parm3.put("email","113131@qq.com");
        Map<String,Object> parm4 = new HashedMap();
        parm4.put("id","1");
        parm4.put("name","张三");
        parm4.put("phone","1231351313");
        parm4.put("email","113131@qq.com");
        Map<String,Object> parm5 = new HashedMap();
        parm5.put("id","1");
        parm5.put("name","张三");
        parm5.put("phone","1231351313");
        parm5.put("email","113131@qq.com");
        list.add(parm1);
        list.add(parm2);
        list.add(parm3);
        list.add(parm4);
        list.add(parm5);
        try {

            BatchExport export = new BatchExport("test.xlsx");
            export.write(response, "text.xlsx",list);
        } catch (Exception e){
            try {
                response.getOutputStream().write(e.getMessage().getBytes());
            } catch (IOException el) {
                el.printStackTrace();
            }
        }

    }
    


}
