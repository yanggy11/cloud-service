package com.yanggy.cloud.service;

import com.yang.cloud.dto.Page;
import com.yang.cloud.dto.ResponseEntity;
import com.yang.cloud.param.RouteParam;

/**
 * Created by derrick.yang on 10/20/17.
 */
public interface IRouteService {
    Page<?> getRoutesListInPage(RouteParam routeParam);

    ResponseEntity<?> disabledRoute(RouteParam routeParam);
}
