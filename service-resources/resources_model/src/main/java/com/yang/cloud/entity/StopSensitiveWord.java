package com.yang.cloud.entity;

import lombok.Data;

/**
 * @author derrick.yang
 * @Date 1/4/19 11:40 AM
 */

@Data
public class StopSensitiveWord extends BaseEntity {
    private String word;
    private int type;
}
