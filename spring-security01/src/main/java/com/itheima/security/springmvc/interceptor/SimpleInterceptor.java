package com.itheima.security.springmvc.interceptor;

import com.itheima.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截器
 */
@Component
public class SimpleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //校验用户请求的URL是否在权限范围
        Object attribute = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if(attribute==null){
            //没有认证，提示登录
            writeContent(response,"请登录！");
        }
        UserDto userDto = (UserDto) attribute;
        //请求的url
        String requestURI = request.getRequestURI();
        if(userDto.getAuthorities().contains("p1") && requestURI.contains("/r/r1")){
            return true;
        }
        if(userDto.getAuthorities().contains("p2") && requestURI.contains("/r/r2")){
            return true;
        }
        return false;
    }

    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(msg);
        writer.close();
        //缓存清除
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
