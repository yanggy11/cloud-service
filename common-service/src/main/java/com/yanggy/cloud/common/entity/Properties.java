package com.yanggy.cloud.common.entity;

import lombok.Data;

/**
 * @author derrick.yang
 * @Date 11/29/18 4:04 PM
 */

@Data
public class Properties {
    private int id;
    private String key;
    private String value;
    private String application;
    private String profile;
    private String label;
}
