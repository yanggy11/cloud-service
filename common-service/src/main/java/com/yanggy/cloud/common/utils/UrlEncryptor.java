package com.yanggy.cloud.common.utils;

/**
 * @author derrick.yang
 * @Date 11/27/18 10:59 AM
 */
public class UrlEncryptor {
    private static final int FACTOR = 6753;

    public static String e(String plainText) {
        String dest = Base64.encode(plainText, FACTOR).toString();
        return dest.replace('-', '_');
    }

    public static String e(int number) {
        return e(String.valueOf(number));
    }

    public static String d(String cipherText) {
        cipherText = cipherText.replace('_', '-');
        return Base64.decodeToStr(cipherText, FACTOR);
    }

    public static int d2Int(String cipherText) {
        return Integer.parseInt(d(cipherText));
    }
}