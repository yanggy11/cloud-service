package com.yanggy.cloud.service.impl;

import com.yang.cloud.dto.Page;
import com.yang.cloud.dto.ResponseEntity;
import com.yang.cloud.mapper.RouteMapper;
import com.yang.cloud.param.RouteParam;
import com.yanggy.cloud.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by derrick.yang on 10/20/17.
 */

@Service("routeService")
public class RouteServiceImpl implements IRouteService {

    @Autowired
    private RouteMapper routeMapper;
    @Override
    public Page<?> getRoutesListInPage(RouteParam routeParam) {
        Page page = new Page();
        page.setPageSize(routeParam.getPageSize());
        page.setPage(routeParam.getPage());
        int count = routeMapper.countRoutes();
        page.setTotalRecord(count);
        page.setTotalPage(count % routeParam.getPageSize() == 0 ? count / routeParam.getPageSize() : count / routeParam.getPageSize() + 1);
        page.setData(routeMapper.getRoutesListInPage(routeParam.getPageSize(), (routeParam.getPage() -1) * routeParam.getPageSize()));

        return page;
    }

    @Override
    public ResponseEntity<?> disabledRoute(RouteParam routeParam) {
        return new ResponseEntity<>(routeMapper.disableRoute(routeParam.getRouteId(), routeParam.isEnabled()));
    }
}
