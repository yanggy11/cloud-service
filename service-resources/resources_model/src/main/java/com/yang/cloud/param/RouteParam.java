package com.yang.cloud.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by derrick.yang on 10/20/17.
 */
@Data
public class RouteParam implements Serializable {
    private Long routeId;
    private boolean enabled;
    private int page;
    private int pageSize = 15;
}
