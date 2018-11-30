package com.yanggy.cloud.common.fegin.configuration;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author derrick.yang
 * @Date 11/30/18 4:44 PM
 */
@Configuration
public class FeignConfiguration {
    public static final int CONNECT_TIMEOUT_MILLIS = 300;
    public static final int READ_TIMEOUT_MILLIS = 300;

    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy(){
        return new FeignHystrixConcurrencyStrategy();
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
