package org.ligson.soeasy.api.enums.user;

/**
 * Created by ligson on 2016/3/24.
 * 登录名类型枚举
 */
public enum LoginNameTypeEnum {

    NAME(0, "登录名"), MOBILE(1, "手机号"), EMAIL(2, "邮箱");
    private int code;
    private String msg;

    LoginNameTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "LoginNameTypeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
