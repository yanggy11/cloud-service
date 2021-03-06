package com.yang.cloud.mapper;

import com.yang.cloud.dto.ResourcesDto;
import com.yang.cloud.entity.Role;
import com.yang.cloud.entity.User;
import com.yang.cloud.param.RoleParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author derrick.yang
 * @Date 9/4/18 14:43
 */
@Component
@Mapper
public interface RoleMapper {
    int deleteRole(List<Long> list);

    List<Role> getRolesByCriteria(RoleParam roleParam);

    List<ResourcesDto> getResourcesByRole(@Param("roleId") Long roleId);

    int addRole(RoleParam role);

    int editRole(RoleParam role);

    int deleteResourcesByRoleId(@Param("id") Long id);

    int insertRoleResources(RoleParam role);

    List<Map> getAllRoles();

    int addUserRoles(User user);

    int deleteUserRole(@Param("id") Long id);

    List<Long> getUserRoleByUserId(@Param("userId") Long id);
}
