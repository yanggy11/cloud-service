package com.yanggy.cloud.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 11/28/18 4:54 PM
 */

@Data
public class ConfigFile implements Serializable {
    private int id;
    private String configName;
}
