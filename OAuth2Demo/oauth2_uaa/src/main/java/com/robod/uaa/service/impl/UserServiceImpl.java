package com.robod.uaa.service.impl;

import com.robod.uaa.entity.SysUser;
import com.robod.uaa.mapper.UserMapper;
import com.robod.uaa.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service("springDataUserDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userMapper.getUserByUsername(username);
        return sysUser;
    }
}
