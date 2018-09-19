package com.yanggy.cloud.config.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author derrick.yang
 * @Date 9/19/18 17:09
 */

@Configuration
public class DynamicRouteConfig {
    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private DataSource dataSource;

    @Bean
    public DynamicRoute routeLocator() {
        DynamicRoute dynamicR = new DynamicRoute(this.serverProperties.getServlet().getServletPrefix(), this.zuulProperties);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dynamicR.setJdbcTemplate(jdbcTemplate);

        return dynamicR;
    }
}
