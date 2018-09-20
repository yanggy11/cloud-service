package com.yanggy.cloud.controller.api;

import com.yanggy.cloud.config.enums.ErrorCode;
import com.yanggy.cloud.config.jwt.JWTUser;
import com.yanggy.cloud.config.jwt.JwtTokenUtil;
import com.yanggy.cloud.entity.param.UserParam;
import com.yanggy.cloud.mapper.UserMapper;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 9/20/18 09:39
 */

@RestController
@RequestMapping("/auth/**")
public class AuthController {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserMapper userMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @PostMapping(value="login")
    public ResponseEntityDto<?> login(@RequestBody UserParam userParam) {

        ResponseEntityDto<?> res = null;
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userParam.getName(), userParam.getPassword());
        Authentication authentication = null;
        Map map = new HashMap();
        try {
            authentication = authenticationManager.authenticate(upToken);
            JWTUser jwtUser = (JWTUser) authentication.getPrincipal();
            final String token = this.tokenHead + jwtTokenUtil.generateToken(jwtUser);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            map.put("token",token);
            map.put("user", jwtUser);

            res = ResponseEntityBuilder.buildNormalResponseEntity(map);
        }catch (BadCredentialsException e) {
            e.printStackTrace();

            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.USER_NAME_PASSWORD_ERROR);

        }catch (Exception e) {
            e.printStackTrace();

            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }
}
