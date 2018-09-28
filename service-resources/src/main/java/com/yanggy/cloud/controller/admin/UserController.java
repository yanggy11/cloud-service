package com.yanggy.cloud.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yanggy.cloud.config.enums.ErrorCode;
import com.yanggy.cloud.dto.Page;
import com.yanggy.cloud.entity.User;
import com.yanggy.cloud.param.UserParam;
import com.yanggy.cloud.service.IUserService;
import com.yanggy.cloud.utils.ResponseEntityBuilder;
import com.yanggy.cloud.utils.ResponseEntityDto;

/**
 * Created by yangguiyun on 2017/6/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public ResponseEntityDto<?> getUserById(@RequestBody UserParam userParam) {
        ResponseEntityDto<?> res = null;
        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(userService.getUserById(userParam.getUserId()));
        } catch (Exception e) {
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @RequestMapping(value = "/userList", method = RequestMethod.POST)
    public ResponseEntityDto<?> getUsers(@RequestBody UserParam userParam) {
    	ResponseEntityDto<?> res;
        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(userService.getUserList(userParam));
        } catch (Exception e) {
            e.printStackTrace();
            
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntityDto<?> userLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        ResponseEntityDto<?> res = null;

        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(userService.login(user));
        } catch (Exception e) {
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ResponseEntityDto<?> updateUserInfo(@RequestBody User user) {
        ResponseEntityDto<?> res = null;

        try {
            userService.update(user);

            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {
            e.printStackTrace();
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntityDto<?> register(@RequestBody User user) {
        ResponseEntityDto<?> res = null;

        try {
            res = ResponseEntityBuilder.buildNormalResponseEntity(userService.register(user));
        } catch (Exception e) {
            e.printStackTrace();
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntityDto<?> deleteUser(@RequestBody UserParam userParam) {
        ResponseEntityDto<?> res = null;

        try {
            userService.deleteUser(userParam.getUserId());

            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntityDto<?> deleteBatchUser(@RequestBody UserParam userParam) {
        ResponseEntityDto<?> res = null;

        try {
            userService.deleteBatchUser(userParam.getUserIds());

            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }

    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    public ResponseEntityDto<?> editPassword(@RequestBody UserParam userParam) {
        ResponseEntityDto<?> res = null;

        try {
            userService.editPassword(userParam);
            res = ResponseEntityBuilder.buildNormalResponseEntity();
        } catch (Exception e) {
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }

        return res;
    }
}
