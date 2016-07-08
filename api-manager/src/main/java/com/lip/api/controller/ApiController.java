package com.lip.api.controller;

import com.lip.api.core.model.Api;
import com.lip.api.core.model.ApiGroup;
import com.lip.api.core.service.ApiGroupService;
import com.lip.api.core.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resources;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@Controller
public class ApiController {
    @Autowired
    private ApiGroupService apiGroupService;
    @Autowired
    private ApiService apiService;
    private static  String MESSAGE="message";

    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public ModelAndView goToPage(@PathVariable("pageName") String pageName) {
        return new ModelAndView(pageName);
    }

    @RequestMapping(value = "/group/getGroup", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getGroup(ApiGroup group) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"处理成功");
        resultMap.put("data",apiGroupService.getApiGroup(group.getId()));
        return resultMap;
    }
    @RequestMapping(value = "/group/getList", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getGroupList() {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("success",true);
        resultMap.put("data",apiGroupService.getGroupList());
        return resultMap;
    }
    @RequestMapping(value = "/group/create", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> createGroup(ApiGroup group) {
        Map<String,Object>resultMap=new HashMap<>();
        apiGroupService.insertApiGroup(group);
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"添加分组成功");
        return resultMap;
    }

    /**
     * 删除一个分组
     * @param group
     * @return
     */
    @RequestMapping(value = "/group/delete", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteGroup(ApiGroup group) {
        Map<String,Object>resultMap=new HashMap<>();
        apiGroupService.deleteApiGroup(group.getId());
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"删除分组成功");
        return resultMap;
    }
    /**
     * 编辑一个分组
     * @param group
     * @return
     */
    @RequestMapping(value = "/group/edit", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> editGroup(ApiGroup group) {
        Map<String,Object>resultMap=new HashMap<>();
        apiGroupService.editApiGroup(group);
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"编辑分组成功");
        return resultMap;
    }
    @RequestMapping(value = "/api/getApi", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getApi(Integer id) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"处理成功");
        resultMap.put("data",apiService.getApi(id));
        return resultMap;
    }
    @RequestMapping(value = "/api/getList", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getApiList() {
        Map<String,Object>resultMap=new HashMap<>();
        List<ApiGroup>groupList=apiGroupService.getGroupList();
        for(ApiGroup group:groupList)
        {
            group.setApis(apiService.getApiList(group.getId()));
        }
        resultMap.put("data",groupList);
        resultMap.put("success",true);
        return resultMap;
    }
    /**
     * 添加一个Api
     * @param api
     * @return
     */
    @RequestMapping(value = "/api/edit", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateApi(Api api) {
        Map<String,Object>resultMap=new HashMap<>();
        apiService.updateApi(api);
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"更新Api成功");
        return resultMap;
    }
    /**
     * 添加一个Api
     * @param api
     * @return
     */
    @RequestMapping(value = "/api/create", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> createApi(Api api) {
        Map<String,Object>resultMap=new HashMap<>();
        apiService.insertApi(api);
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"添加Api成功");
        return resultMap;
    }
    /**
     * 删除一个Api
     * @param api
     * @return
     */
    @RequestMapping(value = "/api/delete", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteApi(Api api) {
        Map<String,Object>resultMap=new HashMap<>();
        apiService.deleteApi(api.getId());
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"删除Api成功");
        return resultMap;
    }
}
