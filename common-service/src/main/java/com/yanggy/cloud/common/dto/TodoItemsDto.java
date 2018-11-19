package com.yanggy.cloud.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:34
 */

@Data
public class TodoItemsDto implements Serializable {
    private Long id;
    private int page = 1;
    private int pageSize = 20;
    private int offset = -1;
    private Long userId;
    private String beginTime;
    private String endTime;
}
