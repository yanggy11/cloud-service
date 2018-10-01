package com.yanggy.cloud.service;

import com.yang.cloud.dto.Page;
import com.yang.cloud.dto.ResponseEntity;
import com.yang.cloud.entity.Resources;
import com.yang.cloud.param.ResourcesParam;

/**
 * Created by yangguiyun on 2017/10/21.
 */
public interface IResourcesService {
    Page<?> getAllRolesInPage(ResourcesParam resourcesParam);

    ResponseEntity<?> deleteRole(ResourcesParam resourcesParam);

    ResponseEntity<?> addRole(Resources resources);

    ResponseEntity<?> editRole(Resources resources);

    ResponseEntity<?> getRoleById(ResourcesParam resourcesParam);

    ResponseEntity<?> getRoleTrees();
}
