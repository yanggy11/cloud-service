package com.yang.cloud.mapper;

import com.yang.cloud.entity.Route;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by derrick.yang on 10/20/17.
 */

@Mapper
public interface RouteMapper {
    List<Route> getRoutesListInPage(@Param("size") int size, @Param("offset") int offset);

    int countRoutes();

    int disableRoute(@Param("routeId") Long routeId, @Param("enabled") boolean enabled);

    int addRoute(Route route);

    int updateRoute(Route route);
}
