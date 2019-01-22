//package com.xiny.config;
//
//import com.xiny.sysConstant.SysConstant;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Created by xiny on 2018/11/5.  shiro替代
// * 安全登陆拦截器
// */
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        if(session.getAttribute(SysConstant.USERSESSION)==null){
//            String path = request.getServletPath();
//            response.sendRedirect(request.getContextPath()+"/login");
//            return false;
//        }
//        String path = request.getServletPath();
//        return true;
//    }
//}
