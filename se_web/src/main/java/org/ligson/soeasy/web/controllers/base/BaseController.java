package org.ligson.soeasy.web.controllers.base;

import org.ligson.soeasy.web.vo.WebResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ligson on 2016/3/31.
 * base
 */
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected WebResult webResult = new WebResult();

    @ModelAttribute
    private void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
