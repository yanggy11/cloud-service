package com.yanggy.cloud.common.service.impl;

import com.yanggy.cloud.common.dto.Page;
import com.yanggy.cloud.common.entity.App;
import com.yanggy.cloud.common.entity.AppConfigRelation;
import com.yanggy.cloud.common.entity.ConfigFile;
import com.yanggy.cloud.common.entity.Properties;
import com.yanggy.cloud.common.mapper.AppConfigRelationMapper;
import com.yanggy.cloud.common.mapper.AppMapper;
import com.yanggy.cloud.common.mapper.ConfigFileMapper;
import com.yanggy.cloud.common.mapper.PropertiesMapper;
import com.yanggy.cloud.common.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 11/28/18 5:06 PM
 */

@Service
public class ConfigServiceImpl implements ConfigService {
    private final static Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);
    @Autowired
    private AppMapper appMapper;

    @Autowired
    private ConfigFileMapper configFileMapper;

    @Autowired
    private PropertiesMapper propertiesMapper;

    @Override
    public List<App> getApps(Page page) {
        logger.info("查询app,查询参数：{}",page);
        int offset = (page.getPage() - 1) * page.getPageSize();
        return appMapper.getApps(offset, page.getPageSize() );
    }

    @Override
    public List<ConfigFile> getConfigFileByAppId(AppConfigRelation app) {
        logger.info("查询APP的配置文件,查询参数：{}",app.getAppId());
        return configFileMapper.getConfigFileByAppId(app.getAppId());
    }

    @Override
    public List<Properties> getProperties(Properties properties) {
        return propertiesMapper.getPropertes(properties);
    }
}
