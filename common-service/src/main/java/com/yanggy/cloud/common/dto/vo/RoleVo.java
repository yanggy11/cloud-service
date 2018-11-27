package com.yanggy.cloud.common.dto.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 11/22/18 3:41 PM
 */

@Data
public class RoleVo implements Serializable {
    private Long id;
    private String role;
}
