package com.lip.api.core.service;

import com.lip.api.core.dao.ApiMapper;
import com.lip.api.core.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@Service
public class ApiService {
    @Autowired
    private ApiMapper apiDao;
    @Autowired
    private ApiGroupService apiGroupService;
    @Autowired
    private ActivityService activityService;
    public List<Api>getApiList(Integer groupId,String key)
    {
        if(StringUtils.isEmpty(key)) {
            ApiExample example = new ApiExample();
            example.createCriteria().andGroupIdEqualTo(groupId);
            return apiDao.selectByExample(example);
        }
        else {
            return apiDao.selectByKeyWord(groupId,"%"+key+"%");
        }
    }
    public void insertApi(Api api)
    {
        api.setCreateTime(new Date());
        api.setUpdateTime(api.getCreateTime());
        apiDao.insertSelective(api);
        int id=apiDao.getInsertId();
        api.setId(id);
        Activity activity=getAcivity(api);
        activity.setAction("添加");
        activityService.insertActivity(activity);
    }

    /**
     * 更新一个Api
     * @param api
     */
    public void updateApi(Api api)
    {
        api.setUpdateTime(new Date());
        apiDao.updateByPrimaryKey(api);
        Activity activity=getAcivity(api);
        activity.setAction("修改");
        activityService.insertActivity(activity);
    }

    /**
     * 删除一个API
     * @param id
     */
    public void deleteApi(int id)
    {
        Api api=apiDao.selectByPrimaryKey(id);
        apiDao.deleteByPrimaryKey(id);
        Activity activity=getAcivity(api);
        activity.setAction("删除");
        activityService.insertActivity(activity);
    }

    /**
     *
     * @param id
     * @return
     */
    public Api getApi(int id)
    {
        return apiDao.selectByPrimaryKey(id);
    }

    public void deleteApiByProject(Integer pid)
    {
        apiDao.deleteByProjectId(pid);
    }

    /**
     * 得到更改日志
     * @param api
     * @return
     */
    public   Activity getAcivity(Api api)
    {
        Activity activity=new Activity();
        activity.setBrief(api.getBrief());
        activity.setApiId(api.getId());
        activity.setApiName(api.getName());
        ApiGroup group=apiGroupService.getApiGroup(api.getGroupId());
        activity.setProjectId(group.getPid());
        return  activity;
    }
}
