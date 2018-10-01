package com.yang.cloud.entity;

import lombok.Data;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 16:54
 * @Description:
 */

@Data
public class Menu extends BaseEntity{
    private static final long serialVersionUID = 5977764443342250526L;

    private String menu;
    private String menuName;
    private String icon;
    private Long parentId;
}
