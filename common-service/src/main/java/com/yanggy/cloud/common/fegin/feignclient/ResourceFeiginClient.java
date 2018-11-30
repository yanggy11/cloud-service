package com.yanggy.cloud.common.fegin.feignclient;


import com.yanggy.cloud.common.dto.vo.UserVo;
import com.yanggy.cloud.common.fegin.configuration.FeignConfiguration;
import com.yanggy.cloud.common.fegin.configuration.FeignHystrixConcurrencyStrategy;
import com.yanggy.cloud.common.fegin.fallback.ResourceHystrixClientFallbackFactory;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 9/23/18 11:41
 */

@FeignClient(value = "RESOURCES",configuration = ResourceFeiginConfiguration.class, fallbackFactory = ResourceHystrixClientFallbackFactory.class)
public interface ResourceFeiginClient {
    @PostMapping(value="/user/getUserById")
    ResponseEntityDto<UserVo> getUserById(Map map);
}

class ResourceFeiginConfiguration {
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
}


