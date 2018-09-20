package com.yanggy.cloud.config.filters;


import java.io.Serializable;

import lombok.Data;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Data
public class User implements Serializable {
    
	private static final long serialVersionUID = -7088247009686136232L;
	
	private long userId;
    private  String username;
    private  String email;
    private  String phone;
    private  String avater;
}
