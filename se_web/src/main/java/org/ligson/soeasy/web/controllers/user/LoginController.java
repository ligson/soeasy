package org.ligson.soeasy.web.controllers.user;

import org.ligson.se.api.dto.LoginRequestDto;
import org.ligson.se.api.dto.RegisterRequestDto;
import org.ligson.soeasy.web.controllers.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ligson on 2016/3/31.
 * 登录相关业务
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping("/login.html")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login.do")
    public String login(LoginRequestDto requestDto) {
        return null;
    }

    @RequestMapping("/logout.do")
    public String logout() {
        return null;
    }

    @RequestMapping("/register.html")
    public String toRegister() {
        return null;
    }

    @RequestMapping("register.do")
    public String register(RegisterRequestDto requestDto) {
        return null;
    }

}
