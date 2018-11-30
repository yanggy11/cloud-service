package com.yang.cloud.mapper;

import com.yang.cloud.entity.User;
import com.yang.cloud.param.UserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/20/18 09:35
 */
@Component
@Mapper
public interface UserMapper {
    User findByName(@Param("username") String name);
    List<String> getUserRoles(@Param("userId") Long userId);
    int insertUser(User user);
    User selectById(@Param("id") long id);
    List<User> getUserList(UserParam userParam);
    int countUsers(UserParam userParam);

    int update(User user);

    int deleteUser(Long userId);

    int editPassword(UserParam userParam);

    int deleteBatchUser(List<Long> list);
}
