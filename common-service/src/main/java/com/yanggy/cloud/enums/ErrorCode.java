package com.yanggy.cloud.enums;

/**
 * @author derrick.yang
 * @Date 8/23/18 16:08
 */
public enum ErrorCode {

    //RPC层调用错误码
    UNKONWN_ERROR("00000" + "001", "未知错误"),
    USER_NAME_PASSWORD_ERROR("00000" + "002", "用户名或密码错误"), AUTHORIZE_FAIL("00000" + "003","鉴权失败");


    private String msg;
    private String code;
    public final static String baseCode = "00000";

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
