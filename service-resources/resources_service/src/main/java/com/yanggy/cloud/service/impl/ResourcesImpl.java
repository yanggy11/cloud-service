package com.yanggy.cloud.service.impl;

import com.yang.cloud.dto.Page;
import com.yang.cloud.dto.ResourcesDto;
import com.yang.cloud.dto.ResponseEntity;
import com.yang.cloud.entity.Resources;
import com.yang.cloud.param.ResourcesParam;
import com.yanggy.cloud.mapper.ResourcesMapper;
import com.yanggy.cloud.service.IResourcesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 10:56
 * @Description:
 */

@Service
public class ResourcesImpl implements IResourcesService {
    @Autowired
    private ResourcesMapper resourcesMapper;
    @Override
    public Page<?> getAllRolesInPage(ResourcesParam resourcesParam) {
        Page page = new Page();
        page.setPageSize(resourcesParam.getPageSize());
        page.setPage(resourcesParam.getPage());
        int count = resourcesMapper.countRoutes(resourcesParam);
        page.setTotalRecord(count);
        page.setTotalPage(count % resourcesParam.getPageSize() == 0 ? count / resourcesParam.getPageSize() : count / resourcesParam.getPageSize() + 1);
        page.setData(resourcesMapper.getAllRolesInpage(resourcesParam.getPageSize(), (resourcesParam.getPage() -1) * resourcesParam.getPageSize()));

        return page;
    }

    @Override
    public ResponseEntity<?> deleteRole(ResourcesParam resourcesParam) {
        //批量删除
        resourcesMapper.deleteRoles(resourcesParam.getResourceIds());
        return new ResponseEntity<>();
    }

    @Override
    public ResponseEntity<?> addRole(Resources resources) {
        return new ResponseEntity<>(resourcesMapper.addRole(resources));
    }

    @Override
    public ResponseEntity<?> editRole(Resources resources) {
        return new ResponseEntity<>(resourcesMapper.editRole(resources));
    }

    @Override
    public ResponseEntity<?> getRoleById(ResourcesParam resourcesParam) {
        return new ResponseEntity<>(resourcesMapper.getRoleById(resourcesParam.getResourceId()));
    }

    @Override
    public ResponseEntity<?> getRoleTrees() {
        List<Resources> resources = resourcesMapper.getAllRoles();

        List<ResourcesDto> trees = resources.stream().filter(resource -> -1 == resource.getParentId()).map((resource) -> {
            ResourcesDto tree = new ResourcesDto();
            BeanUtils.copyProperties(resource, tree);

            List<ResourcesDto>children = this.menuList(resource.getId(), resources);
            tree.setChildren(null == children ? null : children.size() <= 0 ? null : children);

            return tree;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(trees);
    }

    private List<ResourcesDto>menuList(Long id, List<Resources> resources) {
        List<ResourcesDto> children = new ArrayList<>();

        children = resources.stream().filter(resource -> id.equals(resource.getParentId())).map(resource -> {
            ResourcesDto tree = new ResourcesDto();
            BeanUtils.copyProperties(resource, tree);
            tree.setChildren(menuList(resource.getId(), resources));
            return tree;
        }).collect(Collectors.toList());

        return children;
    }
}
