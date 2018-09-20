package com.yanggy.cloud.entity;

import lombok.Data;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Data
public class UserRole extends BaseEntity {
    private static final long serialVersionUID = 3080434653872164123L;

    private long userId;
    private long roleId;
}
