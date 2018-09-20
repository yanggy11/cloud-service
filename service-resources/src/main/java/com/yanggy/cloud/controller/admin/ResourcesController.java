package com.yanggy.cloud.controller.admin;

import com.yanggy.cloud.dto.Page;
import com.yanggy.cloud.dto.ResponseEntity;
import com.yanggy.cloud.entity.Resources;
import com.yanggy.cloud.param.ResourcesParam;
import com.yanggy.cloud.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 10:52
 * @Description:
 */

@RestController
@RequestMapping("/resources/**")
public class ResourcesController {

    @Autowired
    private IResourcesService resourcesService;

    @PostMapping("getAllResourcesInPage")
    public Page<?> getAllRolesInPage(@RequestBody ResourcesParam resourcesParam) {
        return resourcesService.getAllRolesInPage(resourcesParam);
    }
    @PostMapping("deleteResource")
    public ResponseEntity<?> deleteRole(@RequestBody ResourcesParam resourcesParam) {
        return resourcesService.deleteRole(resourcesParam);
    }
    @PostMapping("addResource")
    public ResponseEntity<?> addRole(@RequestBody Resources resources) {
        return resourcesService.addRole(resources);
    }
    @PostMapping("editResource")
    public ResponseEntity<?> editRole(@RequestBody Resources resources) {
        return resourcesService.editRole(resources);
    }
    @PostMapping("getResourceById")
    public ResponseEntity<?> getRoleById(@RequestBody ResourcesParam resourcesParam) {
        return resourcesService.getRoleById(resourcesParam);
    }

    @PostMapping(value="getResourceTrees")
    public ResponseEntity<?> getRoleTrees() {
        return resourcesService.getRoleTrees();
    }
}
