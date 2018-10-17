package com.yanggy.cloud.feigin;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author derrick.yang
 * @Date 10/17/18 10:51
 */

@Configuration
public class FeginRequestInterceptor {
   @Bean
    public RequestInterceptor requestInterceptor() {
       return (template) -> {
           ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
           HttpServletRequest request = attributes.getRequest();
           Enumeration<String> headers = request.getHeaderNames();

           if(null != headers) {
               while(headers.hasMoreElements()) {
                   String header = headers.nextElement();
                   template.header(header, request.getHeader(header));
               }
           }
       };
   }
}
