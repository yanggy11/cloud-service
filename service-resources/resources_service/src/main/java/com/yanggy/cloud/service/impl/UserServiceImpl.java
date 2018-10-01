package com.yanggy.cloud.service.impl;

import com.yang.cloud.dto.Page;
import com.yang.cloud.entity.User;
import com.yang.cloud.param.UserParam;
import com.yanggy.cloud.mapper.RoleMapper;
import com.yanggy.cloud.mapper.UserMapper;
import com.yanggy.cloud.service.IUserService;
import com.yanggy.cloud.utils.PasswordUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yangguiyun on 2017/6/15.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User login(User user) {
        return userMapper.findByName(user.getName());
    }

    @Override
    public User getUserById(long id) {
        User user = userMapper.selectById(id);
        List<Long> userRoles = roleMapper.getUserRoleByUserId(id);
        user.setRoleIds(userRoles);
        return user;
    }

    @Override
    public int register(User user) {
        String password = user.getPassword();
        if(StringUtils.isBlank(password)) {
            password = "123456";
        }
        user.setPassword(PasswordUtil.passwordEncode(password));
        userMapper.insertUser(user);
        roleMapper.addUserRoles(user);
        return 0;
    }

    @Override
    public int update(User user) {
        userMapper.update(user);
        //先删除之前的角色，更新用户角色
        roleMapper.deleteUserRole(user.getId());

        if(user.getRoleIds().size() >= 0) {
            roleMapper.addUserRoles(user);
        }
        return 0;
    }

    @Override
    public Page<List<User>> getUserList(UserParam userParam) {
        Page page = new Page();
        page.setPageSize(userParam.getPageSize());
        page.setPage(userParam.getPage());
        int count = userMapper.countUsers(userParam);
        page.setTotalRecord(count);
        page.setTotalPage(count % userParam.getPageSize() == 0 ? count / userParam.getPageSize() : count / userParam.getPageSize() + 1);
        userParam.setOffset((userParam.getPage() - 1) * userParam.getPageSize());

        List<User> users = userMapper.getUserList(userParam);

        users.parallelStream().forEach(user -> {
            List<Long> roleIds = roleMapper.getUserRoleByUserId(user.getId());
            user.setRoleIds(roleIds);
        });
        page.setData(users);

        return page;
    }

    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void editPassword(UserParam userParam) {
        String password = userParam.getPassword();
        if(StringUtils.isBlank(password)) {
            password = "123456";
        }
        userParam.setPassword(password);
        userMapper.editPassword(userParam);
    }

    @Override
    public void deleteBatchUser(List<Long> userIds) {
        userMapper.deleteBatchUser(userIds);
    }
}
