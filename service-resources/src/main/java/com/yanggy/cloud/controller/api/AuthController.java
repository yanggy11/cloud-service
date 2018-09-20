package com.yanggy.cloud.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanggy.cloud.config.enums.ErrorCode;
import com.yanggy.cloud.config.jwt.JWTUser;
import com.yanggy.cloud.config.jwt.JwtTokenUtil;
import com.yanggy.cloud.param.UserParam;
import com.yanggy.cloud.mapper.UserMapper;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 9/20/18 09:39
 */

@RestController
@RequestMapping("/auth/**")
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
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
        Map<String, Object> map = new HashMap<>();
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
    
    @PostMapping(value="authorization")
    public ResponseEntityDto<?> authorize(@RequestBody Map<String, String> map, HttpServletRequest request) {
    	ResponseEntityDto<?> res = null;
    	
    	try {
    	final String authToken = map.get("token").substring(this.tokenHead.length()); // The part after "Bearer "
        String username = jwtTokenUtil.getUsernameFromToken(authToken);

        logger.info("checking authentication " + username);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
            	
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                logger.info("authenticated user " + username + ", setting security context");
                
                //解析token 返回需要的数据
                res = ResponseEntityBuilder.buildNormalResponseEntity();
            }else {
            	logger.info("鉴权失败，请重新生成");
            	res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.AUTHORIZE_FAIL);
            }
        }
		} catch (Exception e) {
			logger.error("鉴权错误", e);
			res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.AUTHORIZE_FAIL);
		}
		return res;
    }
    
}
