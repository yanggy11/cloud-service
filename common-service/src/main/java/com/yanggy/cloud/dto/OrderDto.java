package com.yanggy.cloud.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author derrick.yang
 * @Date 10/17/18 11:56
 */

@Data
public class OrderDto extends Page {
    private Long id;
    private Long userId;
    private Date beginTime;
    private Date endTime;
}
