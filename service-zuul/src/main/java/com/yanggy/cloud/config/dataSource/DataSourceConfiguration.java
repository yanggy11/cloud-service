package com.yanggy.cloud.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

/**
 * @author derrick.yang
 * @Date 9/19/18 17:46
 */

@Configuration
public class DataSourceConfiguration {

    private DruidDataSource datasource = null;

    @Autowired
    private JdbcProperties jdbcProperties;
    @Bean
    DataSource dataSource() {

        datasource = new DruidDataSource();
        datasource.setUrl(jdbcProperties.getUrl());
        datasource.setDbType(jdbcProperties.getType());
        datasource.setDriverClassName(jdbcProperties.getDriver());
        datasource.setUsername(jdbcProperties.getUsername());
        datasource.setPassword(jdbcProperties.getPassword());

        return datasource;
    }

    @PreDestroy
    public void close() {
        if(null != datasource) {
            datasource.close();
        }
    }
}
