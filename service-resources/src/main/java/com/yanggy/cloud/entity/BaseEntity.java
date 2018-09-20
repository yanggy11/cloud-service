package com.yanggy.cloud.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author derrick.yang
 * @Date 9/20/18 09:33
 */
@Data
public class BaseEntity implements Serializable {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private byte deleteFlag;
}
