package com.yanggy.cloud.service.impl;

import com.yang.cloud.dto.RoleDto;
import com.yang.cloud.entity.Resources;
import com.yang.cloud.entity.Role;
import com.yang.cloud.param.RoleParam;
import com.yanggy.cloud.config.enums.ErrorCode;
import com.yanggy.cloud.mapper.ResourcesMapper;
import com.yanggy.cloud.mapper.RoleMapper;
import com.yanggy.cloud.service.IRoleService;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author derrick.yang
 * @Date 9/5/18 14:13
 */

@Service
public class RoleServiceImpl implements IRoleService {

    private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public ResponseEntityDto<?> deleteRole(RoleParam roleParam) {
        logger.info("删除角色方法开始");
        ResponseEntityDto<?> res = null;

        try {
            roleMapper.deleteRole(roleParam.getRoleIds());

            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {
            logger.info("删除角色发生未知异常", e);

            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        logger.info("删除角色方法结束");

        return res;
    }

    @Override
    public ResponseEntityDto<?> getRoles(RoleParam roleParam) {
        logger.info("查询角色方法开始");
        ResponseEntityDto<?> res = null;

        try {
            List<Role> roles = roleMapper.getRolesByCriteria(roleParam);

            List<RoleDto> roleDtos = roles.stream().parallel().map(role -> {
                RoleDto roleDto = new RoleDto();

                BeanUtils.copyProperties(role, roleDto);

                //查询该角色下的资源
                List<Resources> resources = resourcesMapper.getResourcesByRole(role.getId());
                roleDto.setResources(resources);
                List<Long> resourcesId = resources.parallelStream().map(Resources::getId).collect(Collectors.toList());

                roleDto.setResourcesId(resourcesId);
                return roleDto;
            }).collect(Collectors.toList());

            res = ResponseEntityBuilder.buildNormalResponseEntity(roleDtos);
        } catch (Exception e) {
            logger.info("查询角色发生未知异常", e);

            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        logger.info("查询角色方法结束");

        return res;
    }

    @Override
    public ResponseEntityDto<?> addRole(RoleParam role) {
        ResponseEntityDto<?> res = null;

        try {
            roleMapper.addRole(role);

            roleMapper.insertRoleResources(role);

            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {

            e.printStackTrace();
            logger.info("新增角色发生错误", e.getMessage());
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @Override
    public ResponseEntityDto<?> editRole(RoleParam role) {
        ResponseEntityDto<?> res = null;

        try {
            roleMapper.editRole(role);

            //更新角色的资源列表，先删除后添加
            roleMapper.deleteResourcesByRoleId(role.getId());
            roleMapper.insertRoleResources(role);
            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {

            e.printStackTrace();
            logger.info("编辑角色发生错误", e.getMessage());
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @Override
    public ResponseEntityDto<?> getAllRoles() {
        ResponseEntityDto<?> res = null;
        try {
            List<Map> roles = roleMapper.getAllRoles();

            res = ResponseEntityBuilder.buildNormalResponseEntity(roles);
        } catch (Exception e) {
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }
        return res;
    }
}
