package com.yanggy.cloud.entity;

import lombok.Data;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:18
 */

@Data
public class TodoItems extends BaseEntity {
    private String content;
    private int status;
    private int type;
    private Long userId;
}
