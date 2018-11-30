package com.yanggy.cloud.common.api;

import com.yanggy.cloud.common.config.enums.ErrorCode;
import com.yanggy.cloud.common.dto.Page;
import com.yanggy.cloud.common.entity.AppConfigRelation;
import com.yanggy.cloud.common.entity.Properties;
import com.yanggy.cloud.common.service.ConfigService;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 11/28/18 5:05 PM
 */

@RestController
@RequestMapping("/config/")
public class ConfigController {
    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);
    @Autowired
    private ConfigService configService;

    @GetMapping(value = "apps")
    public ResponseEntityDto<?> getApps(Page page) {
        ResponseEntityDto<?> res;
        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(configService.getApps(page));
        }catch (Exception e) {
            logger.info("查询app发生错误，{}", e.getMessage());
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }
    @GetMapping(value = "configFiles")
    public ResponseEntityDto<?> getConfigFileByAppId(AppConfigRelation app) {
        ResponseEntityDto<?> res;
        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(configService.getConfigFileByAppId(app));
        }catch (Exception e) {
            logger.info("查询app发生错误，{}", e.getMessage());
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @GetMapping(value = "props")
    public ResponseEntityDto<?> getApps(Properties properties) {
        ResponseEntityDto<?> res;
        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(configService.getProperties(properties));
        }catch (Exception e) {
            logger.info("查询配置未见发生错误，请求参数:{},错误信息:{}",properties, e.getMessage());
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }
}
