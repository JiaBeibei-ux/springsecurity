package com.itheima.security.springmvc.controller;


import com.itheima.security.springmvc.model.AuthenicationRequest;
import com.itheima.security.springmvc.model.UserDto;
import com.itheima.security.springmvc.service.AuthenicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private AuthenicationService authenicationService;
    @RequestMapping(value = "/login",produces = {"text/plain;charset=utf-8"})
    public String login(AuthenicationRequest authenicationRequest, HttpSession session){
        UserDto user = authenicationService.authentication(authenicationRequest);
       //存入session
        session.setAttribute(user.SESSION_USER_KEY,user);
        return user.getUsername()+"登录成功！";
    }

    /**
     * 退出功能
     * @return
     */
    @GetMapping(value = "/logout",produces = {"text/plain;charset=utf-8"})
    public String logout(HttpSession session){
      session.invalidate();
      return "退出成功！";
    }
    //测试资源
    @GetMapping(value="/r/r1",produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session){
        String fullname = null;
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(object == null){
            fullname = "匿名";
        }else{
            UserDto userDto = (UserDto) object;
            fullname = userDto.getUsername();
        }
        return fullname+"访问资源r1";
    }
    @GetMapping(value="/r/r2",produces = {"text/plain;charset=utf-8"})
    public String r2(HttpSession session){
        String fullname = null;
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(object == null){
            fullname = "匿名";
        }else{
            UserDto userDto = (UserDto) object;
            fullname = userDto.getUsername();
        }
        return fullname+"访问资源r2";
    }
}
