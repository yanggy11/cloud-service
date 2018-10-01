package com.yanggy.cloud.service;

import com.yang.cloud.param.RoleParam;
import com.yanggy.cloud.utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 9/5/18 14:13
 */
public interface IRoleService {
    ResponseEntityDto<?> deleteRole(RoleParam roleParam);

    ResponseEntityDto<?> getRoles(RoleParam roleParam);

    ResponseEntityDto<?> addRole(RoleParam role);

    ResponseEntityDto<?> editRole(RoleParam role);

    ResponseEntityDto<?> getAllRoles();
}
