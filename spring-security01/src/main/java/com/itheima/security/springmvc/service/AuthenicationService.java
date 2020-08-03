package com.itheima.security.springmvc.service;

import com.itheima.security.springmvc.model.AuthenicationRequest;
import com.itheima.security.springmvc.model.UserDto;

/**
 * 认证接口
 */
public interface AuthenicationService {
     UserDto authentication(AuthenicationRequest authenicationRequest);
}
