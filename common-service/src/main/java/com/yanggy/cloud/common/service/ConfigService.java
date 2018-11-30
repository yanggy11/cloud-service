package com.yanggy.cloud.common.service;

import com.yanggy.cloud.common.dto.Page;
import com.yanggy.cloud.common.entity.App;
import com.yanggy.cloud.common.entity.AppConfigRelation;
import com.yanggy.cloud.common.entity.ConfigFile;
import com.yanggy.cloud.common.entity.Properties;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 11/28/18 5:05 PM
 */
public interface ConfigService {
    List<App> getApps(Page page);

    List<ConfigFile> getConfigFileByAppId(AppConfigRelation app);

    List<Properties> getProperties(Properties properties);
}
