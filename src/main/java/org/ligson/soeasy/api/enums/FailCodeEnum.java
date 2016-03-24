package org.ligson.soeasy.api.enums;

import org.ligson.fw.facade.enums.FailureCodeEnum;

/**
 * Created by ligson on 2016/3/24.
 * 自定义错误代码
 */
public class FailCodeEnum extends FailureCodeEnum {

    public static final FailCodeEnum E_PARAM_1008 = new FailCodeEnum("E_PARAM_1008", "登录名类型不能为空");

    FailCodeEnum(String code, String msg) {
        super(code, msg);
    }
}
