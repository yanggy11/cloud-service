package com.yang.cloud.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/17 12:57
 * @Description:
 */

@Data
public class UserParam implements Serializable {
    
	private static final long serialVersionUID = -1126725563826464213L;
	private Long userId;
    private String name;
    private String password;
    private String confirmPassword;
    private String sex;
    private int page;
    private int pageSize = 15;
    private List<Long> userIds;
    private int offset;
    private List<Long> roleIds;
    private String phone;
    private String timeBegin;
    private String timeEnd;
}
