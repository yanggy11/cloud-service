package com.yanggy.cloud.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 11/28/18 4:54 PM
 */

@Data
public class AppConfigRelation implements Serializable {
    private int id;
    private String label;
    private String profile;
    private int configId;
    private int appId;
}
