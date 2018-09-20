package com.yanggy.cloud.service;

import com.yanggy.cloud.dto.Page;
import com.yanggy.cloud.dto.ResponseEntity;
import com.yanggy.cloud.param.RouteParam;

/**
 * Created by derrick.yang on 10/20/17.
 */
public interface IRouteService {
    Page<?> getRoutesListInPage(RouteParam routeParam);

    ResponseEntity<?> disabledRoute(RouteParam routeParam);
}
