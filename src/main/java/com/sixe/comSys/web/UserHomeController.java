package com.sixe.comSys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/2/25.
 */
@Controller
@RequestMapping(value = "userHome")
public class UserHomeController {

    @RequestMapping(value = "myInfo")
    public String myInfo(){

        return "/user/myInfo";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "/welcome";
    }
}
