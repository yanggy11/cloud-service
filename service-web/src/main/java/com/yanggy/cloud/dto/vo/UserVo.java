package com.yanggy.cloud.dto.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author derrick.yang
 * @Date 25/10/2018 09:14
 */

@Data
public class UserVo implements Serializable {
    private Long id;
    private String name;
    private int sex;
    private int age;
    private String email;
    private String phone;
    private String avater;
}
