package com.yanggy.cloud.config.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author derrick.yang
 * @Date 9/19/18 16:40
 */

public class DynamicRoute extends SimpleRouteLocator implements RefreshableRouteLocator {

    public final static Logger logger = LoggerFactory.getLogger(DynamicRoute.class);
    private static final String DYNAMIC_ROUTE_SQL = "select * from dynamic_route where delete_flag = 0 and enabled = true";

    private ZuulProperties properties;
    private JdbcTemplate jdbcTemplate;

    public DynamicRoute(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.properties = properties;
        logger.info("servletPath:{}", servletPath);
    }

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulRoute> routesMap = new LinkedHashMap<>();
        //从application.properties中加载路由信息
        routesMap.putAll(super.locateRoutes());
        //从db中加载路由信息
        routesMap.putAll(locateDynamicRoute());
        //优化一下配置
        LinkedHashMap<String, ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            // Prepend with slash if not already present.
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        return values;
    }

    private Map<String, ZuulRoute> locateDynamicRoute() {
        List<Route> dynamicRoutes = jdbcTemplate.query(DYNAMIC_ROUTE_SQL, new BeanPropertyRowMapper<>(Route.class));

        Map<String, ZuulRoute>routes = dynamicRoutes.parallelStream().collect(Collectors.toMap(Route::getPath, route -> {
            ZuulRoute zuulRoute = new ZuulRoute();
            BeanUtils.copyProperties(route, zuulRoute);

            return zuulRoute;
        }));

        return routes;
    }

    public ZuulProperties getProperties() {
        return properties;
    }

    public void setProperties(ZuulProperties properties) {
        this.properties = properties;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}


