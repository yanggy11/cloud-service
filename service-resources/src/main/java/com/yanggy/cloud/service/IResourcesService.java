package com.yanggy.cloud.service;

import com.yanggy.cloud.dto.Page;
import com.yanggy.cloud.dto.ResponseEntity;
import com.yanggy.cloud.entity.Resources;
import com.yanggy.cloud.param.ResourcesParam;

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
