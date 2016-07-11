package com.lip.api.controller;

import com.lip.api.core.model.Project;
import com.lip.api.core.service.ProjectService;
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
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    private   String MESSAGE="message";
    @RequestMapping(value = "/project/getList", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getProjectList() {
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("success",true);
        resultMap.put("data",projectService.getProjectList(null));
        return resultMap;
    }
    @RequestMapping(value = "/project/count", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getProjectCount() {
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("success",true);
        Map<String,Object>data=new HashMap<>();
        data.put("created",projectService.getProjectCount());
        resultMap.put("data",data);
        return resultMap;
    }
    @RequestMapping(value = "/project/getProject", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getProject(Integer pid) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("success",true);
        resultMap.put("data",projectService.getProject(pid));
        resultMap.put(MESSAGE,"获取项目成功");
        return resultMap;
    }
    @RequestMapping(value = "/project/statistic", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getStatistic(Integer pid) {
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("success",true);
        Map<String ,Object>data=new HashMap<>();
        data.put("apiNum",projectService.getApiNum(pid));
        data.put("groupNum",projectService.getApiGroupNum(pid));
        resultMap.put("data",data);
        resultMap.put(MESSAGE,"处理成功");
        return resultMap;
    }

    @RequestMapping(value = "/project/create", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> createProject(Project project) {
        Map<String,Object>resultMap=new HashMap<>();
        projectService.createProject(project);
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"添加项目成功");
        return resultMap;
    }

    /**
     * 删除一个项目
     * @param pid
     * @return
     */
    @RequestMapping(value = "/project/delete", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteProject(Integer pid) {
        Map<String,Object>resultMap=new HashMap<>();
        projectService.deleteProject(pid);
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"删除项目成功");
        return resultMap;
    }
    /**
     * 编辑一个项目
     * @param project
     * @return
     */
    @RequestMapping(value = "/project/edit", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> editGroup(Project project) {
        Map<String,Object>resultMap=new HashMap<>();
        projectService.editProject(project);
        resultMap.put("success",true);
        resultMap.put(MESSAGE,"编辑项目成功");
        return resultMap;
    }
}
