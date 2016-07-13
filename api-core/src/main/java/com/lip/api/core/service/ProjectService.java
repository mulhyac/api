package com.lip.api.core.service;

import com.lip.api.core.dao.ProjectMapper;
import com.lip.api.core.model.Project;
import com.lip.api.core.model.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/11 0011.
 */
@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectDao;
    @Autowired
    private ApiGroupService apiGroupService;
    @Autowired
    private ApiService apiService;

    /**
     * 得到一个项目
     * @param id
     * @return
     */
    public Project getProject(Integer id)
    {
        return projectDao.selectByPrimaryKey(id);
    }

    /**
     * 插入一个项目
     * @param project
     */
    public int createProject(Project project)
    {
        project.setCreateTime(new Date());
        project.setUpdateTime(project.getCreateTime());
        projectDao.insertSelective(project);
        return projectDao.getInsertId();
    }

    /**
     * 得到项目列表
     * @param project
     * @return
     */
    public List<Project>getProjectList(Project project)
    {
        ProjectExample example=new ProjectExample();
        return  projectDao.selectByExample(example);
    }

    /**
     * 更新项目
     * @param project
     */
    public void editProject(Project project)
    {
        project.setUpdateTime(new Date());
        projectDao.updateByPrimaryKey(project);
    }

    /**
     * 删除一个项目
     * @param id
     */
    public void deleteProject(Integer id)
    {
        apiService.deleteApiByProject(id);
        apiGroupService.deleteByProject(id);
        projectDao.deleteByPrimaryKey(id);
    }
    public Integer getProjectCount()
    {
        ProjectExample example=new ProjectExample();
        return projectDao.countByExample(example);
    }
    public int getApiNum(Integer pid)
    {
        return projectDao.getApiNum(pid);
    }
    public int getApiGroupNum(Integer pid)
    {
        return projectDao.getApiGroupNum(pid);
    }
}
