package com.sixe.comSys.web;

import com.sixe.comSys.base.SessionInterceptor;
import com.sixe.comSys.base.SpringContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/24.
 */

@Controller
@RequestMapping(value = "myHome")
public class MyHomeController {

    /**
     * 用户登录成功跳转中心
     * @return
     */
    @RequestMapping(value = "/goMyHome")
    public String goMyHome(HttpServletRequest request, HttpServletResponse response){
        //判断用户角色
        int user_level = SpringContextHolder.getCurrentUser().getResult().getUser_level();
        if("12".equals(user_level+"")){//12.普通用户,11.高级用户，10.公司管理员
            //普通用户进入...
            return "/user/home";
        }else{
            //管理员用户进入...
            request.setAttribute("units",SpringContextHolder.getCurrentUser().getResult().getUnits());
            return "/admin/adminHome";
        }
    }

    /**
     * 进入单位信息管理
     * @return
     */
    @RequestMapping(value = "/goComInfo")
    public String goComInfo(String id){

        return "/com/info";
    }

    /**
     * 进入DTU管理
     * @return
     */
    @RequestMapping(value = "/goDTUConfig")
    public String goDTUConfig(String id){

        return "/com/DTU";
    }

    /**
     * 进入单位用户管理
     * @return
     */
    @RequestMapping(value = "/goComUser")
    public String goComUser(String id){

        return "/com/comUser";
    }
}
