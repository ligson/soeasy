package org.ligson.se.biz.user;

import org.ligson.fw.core.biz.AbstractBiz;
import org.ligson.fw.core.biz.paramcheck.CommonParamCheck;
import org.ligson.fw.core.facade.enums.FailureCodeEnum;
import org.ligson.fw.core.utils.annotation.Api;
import org.ligson.se.api.dto.RegisterRequestDto;
import org.ligson.se.api.dto.RegisterResponseDto;
import org.ligson.se.api.vo.User;
import org.ligson.se.entity.UserEntity;
import org.ligson.se.service.UserService;
import org.ligson.se.utils.IdUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by ligson on 2016/3/28.
 * 用户注册接口
 */
@Component(value = "register")
@Api(name = "用户注册接口")
public class RegisterBiz extends AbstractBiz<RegisterRequestDto, RegisterResponseDto> {
    @Resource
    private UserService userService;

    @Override
    public void before() {

    }

    @Override
    public Boolean paramCheck() {
        //requestDto.getName()
        if (!StringUtils.isEmpty(requestDto.getMobile())) {
            if (!CommonParamCheck.isValidMobile(requestDto.getMobile(), context, responseDto.getClass())) {
                return false;
            }
        }
        if (!StringUtils.isEmpty(requestDto.getEmail())) {
            if (!CommonParamCheck.isValidEmail(requestDto.getEmail(), context, responseDto.getClass())) {
                return false;
            }
        }

        if (!StringUtils.isEmpty(requestDto.getName())) {
            if (!CommonParamCheck.isValidName(requestDto.getName(), context, responseDto.getClass())) {
                return false;
            }
        }
        if (StringUtils.isEmpty(requestDto.getPassword())) {
            setFailureResult(FailureCodeEnum.E_PARAM_10003);
            return false;
        }

        return true;
    }

    @Override
    public Boolean bizCheck() {
        if (!StringUtils.isEmpty(requestDto.getName())) {
            UserEntity entity = new UserEntity();
            entity.setName(requestDto.getName());
            int n = userService.countBy(entity);
            if (n > 0) {
                setFailureResult(FailureCodeEnum.E_BIZ_20001);
                return false;
            }
        }
        if (!StringUtils.isEmpty(requestDto.getMobile())) {
            UserEntity entity = new UserEntity();
            entity.setMobile(requestDto.getMobile());
            int n = userService.countBy(entity);
            if (n > 0) {
                setFailureResult(FailureCodeEnum.E_BIZ_20006);
                return false;
            }
        }
        if (!StringUtils.isEmpty(requestDto.getEmail())) {
            UserEntity entity = new UserEntity();
            entity.setEmail(requestDto.getEmail());
            int n = userService.countBy(entity);
            if (n > 0) {
                setFailureResult(FailureCodeEnum.E_BIZ_20005);
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean txnPreProcessing() {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(requestDto, entity);
        entity.setId(IdUtils.randomId());
        context.setAttr("entity", entity);
        return true;
    }

    @Override
    public Boolean persistence() {
        UserEntity entity = (UserEntity) context.getAttr("entity");
        try {
            userService.add(entity);
        } catch (Exception e) {
            e.printStackTrace();
            setFailureResult(FailureCodeEnum.E_PERSIST_40001);
            return false;
        }
        User user = new User();
        BeanUtils.copyProperties(entity, user);
        responseDto.setUser(user);
        setSuccessResult();
        return true;
    }

    @Override
    public void after() {

    }
}
