package com.sixe.comSys.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sixe.comSys.utils.Tools;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wuqiang on 2017/3/1.
 */
public class SessionInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
                             Object o) throws Exception {
        // TODO Auto-generated method stub
        if (Tools.isEmpty(req.getSession())) {
            resp.sendRedirect("/comSys/home/login");
            return false;
        }else if(Tools.isEmpty(req.getSession().getAttribute(Contants.USER_SESSION_INFO))){
            resp.sendRedirect("/comSys/home/login");
            return false;
        }else{
            return true;
        }
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
