package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.SpringContextHolder;
import com.sixe.comSys.dto.QueryUserInfo.QueryUserInfoParam;
import com.sixe.comSys.utils.HttpTools;
import com.sixe.comSys.utils.ProperUtils;
import org.apache.commons.collections.map.HashedMap;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wuqiang on 2017/2/25.
 */
@Controller
@RequestMapping(value = "userHome")
public class UserHomeController {

    private static final Logger logger = Logger.getLogger(UserHomeController.class);

    @RequestMapping(value = "/myInfo")
    public String myInfo(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashedMap();
        map.put("user_id", SpringContextHolder.getCurrentUser().getResult().getUser_id());
        logger.info("请求参数："+map.toString());
        String result = HttpTools.sendPost(ProperUtils.getVal("reqUrl")+"querry_user_info.php",map);
        logger.info("返回结果："+result);
        JSONObject jsonObj = JSON.parseObject(result);
        String state=jsonObj.getString("state");
        if("200".equals(state)){
            //请求成功
            Gson gson = new Gson();
            QueryUserInfoParam param = gson.fromJson(result,QueryUserInfoParam.class);
            logger.info("用户真实姓名："+param.getResult().getUser_full_name());
            request.setAttribute("userInfo",param.getResult());
        }
        return "/user/myInfo";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "/welcome";
    }
}
