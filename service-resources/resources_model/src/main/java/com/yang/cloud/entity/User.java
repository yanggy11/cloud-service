package com.yang.cloud.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/20/18 09:34
 */

@Data
public class User extends BaseEntity {
    
	private static final long serialVersionUID = 1582780516468586216L;
	private String name;
    private String password;
    private int sex;
    private int age;
    private String email;
    private String phone;
    private List<String> authorities = new ArrayList<>();
    private String avater;
    private List<Long> roleIds;
}
