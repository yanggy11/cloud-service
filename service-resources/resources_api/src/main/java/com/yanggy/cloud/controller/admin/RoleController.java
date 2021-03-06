package com.yanggy.cloud.controller.admin;

import com.yang.cloud.param.RoleParam;
import com.yanggy.cloud.service.IRoleService;
import com.yanggy.cloud.utils.ResponseEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author derrick.yang
 * @Date 9/5/18 13:20
 */

@RestController
@RequestMapping(value = "/role/**")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @DeleteMapping(value = "deleteRole")
    public ResponseEntityDto<?> deleteRole(@RequestBody RoleParam roleParam) {

        return roleService.deleteRole(roleParam);
    }

    @PostMapping(value = "getRolesByCriteria")
    public ResponseEntityDto<?> getRolesByCriteria(@RequestBody RoleParam roleParam) {

        return roleService.getRoles(roleParam);
    }

    @PostMapping(value = "addRole")
    public ResponseEntityDto<?> addRole(@RequestBody RoleParam role) {

        return roleService.addRole(role);
    }

    @PostMapping(value = "editRole")
    public ResponseEntityDto<?> editRole(@RequestBody RoleParam role) {

        return roleService.editRole(role);
    }
    @PostMapping(value = "getAllRoles")
    public ResponseEntityDto<?> getAllRoles() {
        System.out.println(new Date());
        return roleService.getAllRoles();
    }
}
