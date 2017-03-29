package com.sixe.comSys.base;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 高级用户（以上级别）拦截器
 * Created by wuqiang on 2017/3/29-0029.
 */
public class UserPermissionAdvancedInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
                             Object o) throws Exception {
        System.out.println("进入用户权限拦截器【高级用户拦截器】.....【getUser_level】："+SpringContextHolder.getCurrentUser().getResult().getUser_level());
        // 用户权限拦截  //12.普通用户,11.高级用户，10.公司管理员
        if("10".equals( SpringContextHolder.getCurrentUser().getResult().getUser_level()+"")
                ||"11".equals( SpringContextHolder.getCurrentUser().getResult().getUser_level()+"")) {//公司管理员或高级用户
            return true;
        }
        System.out.println("用户权限不足....");
        resp.sendRedirect("/comSys/home/permissionDenied");
        return false;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
