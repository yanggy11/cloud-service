package com.yanggy.cloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Data
public class Resources extends BaseEntity {
    private static final long serialVersionUID = -6995148327145747896L;
    private Long parentId;
    private String resource;
    private String resourceName;
}
