package com.lip.api.controller;

import com.lip.api.core.model.ApiMethod;
import com.lip.api.core.service.ApiMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resources;
import javax.inject.Inject;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@Controller
public class ApiController {
    @Autowired
    private ApiMethodService apiMethodService;

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public
    @ResponseBody
    String getApi() {
        //return apiMethodService.getMethod(1);
        return "hello";
    }
    @RequestMapping(value = "/apis", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiMethod getApis() {
        return apiMethodService.getMethod(1);
    }
}
