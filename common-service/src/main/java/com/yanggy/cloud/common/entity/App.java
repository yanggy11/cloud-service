package com.yanggy.cloud.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author derrick.yang
 * @Date 11/28/18 4:54 PM
 */

@Data
public class App implements Serializable {
    private int id;
    private String sysName;
    private String sysNameCn;
    private String appGroup;
    private Date createTime;
    private Date updateTime;
}
