package com.yanggy.cloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/18 10:58
 * @Description:
 */

@Data
public class DynamicTree extends BaseEntity {
    private static final long serialVersionUID = 6310408155166158309L;

    private Long parentId;
    private String name;
    private String remark;
}
