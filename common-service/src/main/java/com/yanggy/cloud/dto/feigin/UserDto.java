package com.yanggy.cloud.dto.feigin;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author derrick.yang
 * @Date 10/17/18 11:06
 */
@Data
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private int sex;
    private Long userId;
    private int age;
    private String email;
    private String phone;
    private List<String> authorities = new ArrayList<>();
    private String avater;
    private List<Long> roleIds;
}
