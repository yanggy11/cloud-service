package com.yanggy.cloud.utils;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 15:43
 * @Description:
 */
public final class PasswordUtil {
	
	private static SCryptPasswordEncoder sCryptPasswordEncoder;

	public static SCryptPasswordEncoder getPasswordEncoder() {
		if (null == sCryptPasswordEncoder) {
			return new SCryptPasswordEncoder();
		}

		return sCryptPasswordEncoder;
	}

	public static String passwordEncode(String password) {
		return getPasswordEncoder().encode(password);
	}
}
