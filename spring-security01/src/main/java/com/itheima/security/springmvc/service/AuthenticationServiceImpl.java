package com.itheima.security.springmvc.service;

import com.itheima.security.springmvc.model.AuthenicationRequest;
import com.itheima.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenicationService{

    @Override
    public UserDto authentication(AuthenicationRequest authenicationRequest) {
        //校验用户什么
        if(authenicationRequest == null ||
                StringUtils.isEmpty(authenicationRequest.getUsername())
                || StringUtils.isEmpty(authenicationRequest.getPassword())){
            //根据用户名和密码 比对
            return null;
        }
        //模拟数据库查询
        UserDto userDto = getUserDto(authenicationRequest.getUsername());
        if(userDto == null){
            throw new RuntimeException("查询不到用户！");
        }
        if(!authenicationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("账号或密码错误");
        }
        //验证通过 返回信息
        return  userDto;
    }

    //根据账号查询信息
    private UserDto getUserDto(String userName){
        return userMap.get(userName);
    }

    //用户信息
    private Map<String,UserDto> userMap = new HashMap<>();
    {
        //分配权限
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("p1");//认为p1和r/r1对应
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("p2");
        userMap.put("zhangsan",new UserDto("001","zhangsan","123","张三","133",authorities1));
        userMap.put("Jack",new UserDto("002","Jack","123","杰克","1333",authorities2));
    }

}
