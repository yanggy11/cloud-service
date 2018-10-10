package com.yanggy.cloud.config.jwt;


import com.yang.cloud.entity.User;
import com.yang.cloud.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Service("userDetailsService")
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = new User();
        try {
            user = userMapper.findByName(name);
            user.setAuthorities(userMapper.getUserRoles(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == user) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", name));
        }
        return JwtUserFactory.create(user, userMapper.getUserRoles(user.getId()));
    }
}
