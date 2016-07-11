package com.lip.api.controller;

import com.lip.api.core.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/11 0011.
 */
@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    private   String MESSAGE="message";
    @RequestMapping(value = "/activity/getList",method= RequestMethod.GET)
    public @ResponseBody Map<String,Object>getActivityList(Integer pid)
    {
        Map<String,Object>result=new HashMap<>();
        result.put("data",activityService.getActivityList(pid));
        result.put("success",true);
        result.put(MESSAGE,"成功获取日志");
        return result;
    }
}
