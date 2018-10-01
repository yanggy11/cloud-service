package com.yang.cloud.dto;

import com.yang.cloud.entity.Resources;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/5/18 14:24
 */

@Data
public class RoleDto implements Serializable {
    
	private static final long serialVersionUID = -4742724300794166562L;
	private Long id;
    private String role;
    private String roleName;

    private String remark;

    private List<Resources>resources;
    private List<Long> resourcesId;
    private boolean disabled;
}
