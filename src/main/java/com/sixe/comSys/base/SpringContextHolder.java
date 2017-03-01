package com.sixe.comSys.base;

import com.sixe.comSys.dto.DoLogin.DoLoginParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by labiStronger on 2017/3/1.
 */
public class SpringContextHolder {

    public static ServletRequestAttributes getSrAttrs() {
        ServletRequestAttributes srAttrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return srAttrs;
    }

    public static HttpSession getSession() {
        return getSrAttrs().getRequest().getSession();
    }

    public static DoLoginParam getCurrentUser() {
        return (DoLoginParam)getSession().getAttribute(Contants.USER_SESSION_INFO);
    }

    public static HttpServletRequest getRequest() {
        return getSrAttrs().getRequest();
    }
}
