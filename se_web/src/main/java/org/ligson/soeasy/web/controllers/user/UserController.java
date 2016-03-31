package org.ligson.soeasy.web.controllers.user;

import org.ligson.soeasy.web.controllers.base.BaseController;
import org.ligson.soeasy.web.vo.WebResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ligson on 2016/3/31.
 * user
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/list.do")
    public String toList() {
        return null;
    }

    @RequestMapping("/list.json")
    public WebResult list() {
        return webResult;
    }
}
