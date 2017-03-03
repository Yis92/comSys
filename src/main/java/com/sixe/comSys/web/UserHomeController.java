package com.sixe.comSys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sixe.comSys.base.SpringContextHolder;
import com.sixe.comSys.dto.QueryUserInfo.QueryUserInfoParam;
import com.sixe.comSys.utils.HttpClientUtil;
import com.sixe.comSys.utils.HttpTools;
import com.sixe.comSys.utils.ProperUtils;
import com.sixe.comSys.utils.Tools;
import org.apache.commons.collections.map.HashedMap;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     *  进入我的信息
     * @param request
     * @param response
     * @return
     */
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

    /**
     * 修改我的信息
     * @param userId
     * @param fullName
     * @param desc
     * @param phone1
     * @param phone2
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updInfo")
    public String updInfo(String userId,String fullName,String desc,String phone1,String phone2) throws Exception {
        Map<String,String> map = new HashedMap();
        map.put("user_id", SpringContextHolder.getCurrentUser().getResult().getUser_id());
        map.put("user_full_name",fullName);
        map.put("user_describ",desc);
        map.put("user_tel1",phone1);
        map.put("user_tel2",phone2);
        logger.info("请求参数："+map.toString());
        String result = HttpClientUtil.doHttpPost(ProperUtils.getVal("reqUrl")+"update_user_info.php","UTF-8",map,10000);
        //String result = HttpTools.sendPost(ProperUtils.getVal("reqUrl")+"update_user_info.php",map);
        logger.info("返回结果："+result);
        JSONObject jsonObj = JSON.parseObject(result);
        String state=jsonObj.getString("state");
        if("200".equals(state)){
            logger.info("修改成功...");
            return Tools.sendJson("SUC");
        }
        String message = jsonObj.getString("message");
        logger.info("修改失败【message】:"+message);
        return Tools.sendJson(message);
    }

    /**
     * 修改密码
     * @param password
     * @param upass
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updPwd")
    public String updPwd(String password,String upass){
        Map<String,Object> map = new HashedMap();
        map.put("user_id", SpringContextHolder.getCurrentUser().getResult().getUser_id());
        map.put("pwd_old",password);
        map.put("pwd_new",upass);
        logger.info("请求参数："+map.toString());
        String result = HttpTools.sendPost(ProperUtils.getVal("reqUrl")+"update_user_pwd.php",map);
        logger.info("返回结果："+result);
        JSONObject jsonObj = JSON.parseObject(result);
        String state=jsonObj.getString("state");
        if("200".equals(state)){
            logger.info("密码修改成功...");
            return Tools.sendJson("SUC");
        }
        String message = jsonObj.getString("message");
        logger.info("密码修改失败【message】:"+message);
        return Tools.sendJson(message);
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "/welcome";
    }
}
