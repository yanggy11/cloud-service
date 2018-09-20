package com.yanggy.cloud.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 17:01
 * @Description:
 */

@Data
public class MenuParam implements Serializable {
    private Long menuId;
    private int page = 1;
    private int pageSize = 15;
    private Long parentMenuId;
    private String menuName;
    private String menu;
    private int offset;
}
