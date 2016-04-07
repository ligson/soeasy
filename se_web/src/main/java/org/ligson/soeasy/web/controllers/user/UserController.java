package org.ligson.soeasy.web.controllers.user;

import org.ligson.fw.core.facade.base.result.Result;
import org.ligson.se.api.UserApi;
import org.ligson.se.api.dto.ChkLoginNameValidRequestDto;
import org.ligson.se.api.dto.ChkLoginNameValidResponseDto;
import org.ligson.se.api.enums.user.LoginNameTypeEnum;
import org.ligson.soeasy.web.controllers.base.BaseController;
import org.ligson.soeasy.web.vo.WebResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by ligson on 2016/3/31.
 * user
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserApi userApi;

    @RequestMapping("/list.do")
    public String toList() {
        return null;
    }

    @RequestMapping("/list.json")
    public WebResult list() {
        return webResult;
    }

    @RequestMapping("/checkName.json")
    @ResponseBody
    public WebResult checkName(String name) {
        ChkLoginNameValidRequestDto requestDto = new ChkLoginNameValidRequestDto();
        requestDto.setLoginName(name);
        requestDto.setLoginNameTypeEnum(LoginNameTypeEnum.NAME);
        Result<ChkLoginNameValidResponseDto> result = userApi.checkLoginName(requestDto);
        if (result.isSuccess()) {
            webResult.setSuccess(result.getData().getSuccess());
        } else {
            logger.error("接口调用错误,code:{},msg:{}", result.getFailureCode(), result.getFailureMessage());
            webResult.setSuccess(false);
            webResult.setError(result);
        }
        webResult.put("valid", webResult.getSuccess());
        return webResult;
    }
}
