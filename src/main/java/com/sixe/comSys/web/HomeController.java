package com.sixe.comSys.web;

import com.sixe.comSys.base.imgCode.ValidateCode;
import com.sixe.comSys.utils.HttpTools;
import com.sixe.comSys.utils.Tools;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;


/**
 * Created by labiStronger on 2017/2/24.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);

    /**
     * 进入登录页...
     * @return
     */
    @RequestMapping(value="login")
    public String login(){
        logger.info("进入登录页...");
        System.out.println("进入登录页...");
        return "/login";
    }

    /**
     * 图片验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/randomImg")
    public void randomImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ValidateCode vCode = new ValidateCode(120,40,4,60,response);
        vCode.write(response.getOutputStream());
        System.out.println("Code::"+vCode.getCode());
        request.getSession().setAttribute("code", vCode.getCode());
    }

    /**
     * 验证图片验证码
     * @param code
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/checkCode")
    public String checkCode(String code,HttpServletRequest request, HttpServletResponse response){
        String sessionCode = (String) request.getSession().getAttribute("code");
		/*设置不区分大小写  全部转为大写比较*/
        String newSessionCode = sessionCode.toUpperCase();
        String newCode = code.toUpperCase();
        if(newSessionCode.equals(newCode)){
            return Tools.sendJson("SUC");
        }
        return Tools.sendJson("FIL");
    }

    /**
     * 执行登录操作
     * @param user_id
     * @param pwd
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/doLogin")
    public String doLogin(String user_id,String pwd){

        logger.info("userId:"+user_id);
        Map<String,Object> map = new HashedMap();
        map.put("user_id",user_id);
        map.put("pwd",pwd);

        String result = HttpTools.sendPost("http://139.129.239.172:7710/php/check_usr.php",map);
        System.out.println(result);

        if("wk".equals(user_id)){
            return "SUC";
        }else{
            return "SUC1";
        }
    }

}
