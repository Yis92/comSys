package com.sixe.comSys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/2/24.
 */

@Controller
@RequestMapping(value = "myHome")
public class MyHomeController {

    /**
     * 普通用户进入
     * @return
     */
    @RequestMapping(value = "/goMyHome")
    public String goMyHome(){
        //判断用户角色

        //return "/admin/home";

        //普通用户进入...
        return "/user/home";
    }

    @RequestMapping(value = "/goMyHome2")
    public String goMyHome2(){
        //判断用户角色

        return "/admin/adminHome";

        //普通用户进入...
        //return "/user/home";
    }

    /**
     * 进入单位信息管理
     * @return
     */
    @RequestMapping(value = "/goComInfo")
    public String goComInfo(){

        return "/com/info";
    }

    /**
     * 进入DTU管理
     * @return
     */
    @RequestMapping(value = "/goDTUConfig")
    public String goDTUConfig(){

        return "/com/DTU";
    }

    /**
     * 进入单位用户管理
     * @return
     */
    @RequestMapping(value = "/goComUser")
    public String goComUser(){

        return "/com/comUser";
    }
}
