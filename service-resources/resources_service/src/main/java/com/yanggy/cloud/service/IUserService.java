package com.yanggy.cloud.service;

import com.yang.cloud.dto.Page;
import com.yang.cloud.entity.User;
import com.yang.cloud.param.UserParam;

import java.util.List;

/**
 * Created by yangguiyun on 2017/6/15.
 */
public interface IUserService {
    User login(User user);
    User getUserById(long id);
    int register(User user);
    int update(User user);
    Page<List<User>> getUserList(UserParam userParam);
    void deleteUser(Long userId);
    void editPassword(UserParam userParam);

    void deleteBatchUser(List<Long> userIds);
}
