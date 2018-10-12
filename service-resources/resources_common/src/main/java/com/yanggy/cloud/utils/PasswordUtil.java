package com.yanggy.cloud.utils;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 15:43
 * @Description:
 */
public final class PasswordUtil {
	
	private static SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();

	public static SCryptPasswordEncoder getPasswordEncoder() {

		return sCryptPasswordEncoder;
	}

	public static String passwordEncode(String password) {
		return getPasswordEncoder().encode(password);
	}
}
