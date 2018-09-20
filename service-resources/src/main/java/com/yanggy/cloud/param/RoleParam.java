package com.yanggy.cloud.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/5/18 14:08
 */

@Data
public class RoleParam implements Serializable {
    private Long roleId;
    private int page = 1;
    private int pageSize = 20;
    private int offset = -1;
    private List<Long> roleIds;
    private Long id;
    private List<Long> resourcesIds;
    private String role;
    private String roleName;
    private String remark;
}
