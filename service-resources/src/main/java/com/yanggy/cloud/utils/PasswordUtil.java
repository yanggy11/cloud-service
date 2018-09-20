package com.yanggy.cloud.utils;

import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 15:43
 * @Description:
 */
@SuppressWarnings("deprecation")
public final class PasswordUtil {
	
	private static MessageDigestPasswordEncoder md5PasswordEncoder;

	public static MessageDigestPasswordEncoder getMd5PasswordEncoder() {
		if (null == md5PasswordEncoder) {
			return new MessageDigestPasswordEncoder("MD5");
		}

		return md5PasswordEncoder;
	}

	public static String md5Encoder(String password, String salt) {
		return getMd5PasswordEncoder().encode(password);
	}
}
