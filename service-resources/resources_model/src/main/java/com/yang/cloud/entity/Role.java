package com.yang.cloud.entity;

import lombok.Data;

/**
 * @author derrick.yang
 * @Date 9/4/18 14:40
 */

@Data
public class Role extends BaseEntity {
    
	private static final long serialVersionUID = -3992895995454827557L;
	private String role;
    private String roleName;

    private String remark;
}
