package com.yanggy.cloud.common.feginclients;


import com.yanggy.cloud.common.dto.vo.RoleVo;
import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 9/23/18 11:41
 */

@Component
@FeignClient(value = "RESOURCES",configuration = FeiginConfiguration.class, fallbackFactory = HystrixClientFallbackFactory.class)
public interface ResourceFeiginClient {
    @PostMapping(value="/role/getAllRoles")
    ResponseEntityDto<List<RoleVo>> getAllRoles();

    @PostMapping(value="/user/getUserById")
    ResponseEntityDto<UserVo> getUserById(Map map);
}

class FeiginConfiguration {
    public static final int CONNECT_TIMEOUT_MILLIS = 2000;
    public static final int READ_TIMEOUT_MILLIS = 2000;
    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy(){
        return new FeignHystrixConcurrencyStrategy();
    }

    /**
     * feign拦截器
     * @return
     */
    @Bean
    public RequestInterceptor headerInterceptor() {
        return (template) -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (null != headerNames) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    template.header(name, values);
                }
            }
        };
    }

    /**
     * 修改feign默认日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 连接、读取超时时间
     * @return
     */
    @Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(CONNECT_TIMEOUT_MILLIS, READ_TIMEOUT_MILLIS);
    }

    @Bean
    public Retryer feignRetryer() {
        Retryer retryer = new Retryer.Default(100, 1000, 4);
        return retryer;
    }
}


