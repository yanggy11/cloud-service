package com.yanggy.cloud.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author derrick.yang
 * @Date 9/1/18 10:20
 */

@ConfigurationProperties(prefix = OssProperties.ALI_OSS_PREFIX)
@Component
@RefreshScope
@Data
public class OssProperties {
    final static String ALI_OSS_PREFIX = "ali.oss";
    private String accessKeyId;
    private String accessKeySecret;
    private String bucket;
    private String endpoint;
    private String bucketEndpoint;
}
