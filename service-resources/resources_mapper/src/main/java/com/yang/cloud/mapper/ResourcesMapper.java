package com.yang.cloud.mapper;

import com.yang.cloud.entity.Resources;
import com.yang.cloud.param.ResourcesParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yangguiyun on 2017/10/21.
 */
@Component
@Mapper
public interface ResourcesMapper {
    List<String> getAllRolesInpage(@Param("size") int size, @Param("offset") int offset);

    int countRoutes(ResourcesParam resourcesParam);

    int deleteRole(@Param("roleId") Long roleId);
    int deleteRoles(List<Long> list);

    int addRole(Resources resources);

    int editRole(Resources resources);

    int deleteUserRole(@Param("roleId") Long roleId);

    Resources getRoleById(@Param("roleId") Long roleId);
    List<Resources> getAllRoles();

    List<Resources>getResourcesByRole(@Param("roleId") Long roleId);
}
