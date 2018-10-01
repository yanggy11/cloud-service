package com.yanggy.cloud.controller.admin;

import com.yang.cloud.dto.Page;
import com.yang.cloud.dto.ResponseEntity;
import com.yang.cloud.param.RouteParam;
import com.yanggy.cloud.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by derrick.yang on 10/20/17.
 */

@RestController
@RequestMapping("/route/**")
public class RouteController {

    @Autowired
    private IRouteService routeService;

    @PostMapping(value = "getAllRoutesInPage")
    public Page<?> getAllRoutesInPage(@RequestBody RouteParam routeParam) {
        return routeService.getRoutesListInPage(routeParam);
    }

    @PostMapping("disableRoute")
    public ResponseEntity<?> disableRoute(@RequestBody RouteParam routeParam) {
        return routeService.disabledRoute(routeParam);
    }
}
