package com.lip.api.core.service;

import com.lip.api.core.dao.ApiGroupMapper;
import com.lip.api.core.model.ApiGroup;
import com.lip.api.core.model.ApiGroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@Service
public class ApiGroupService {
    @Autowired
    private ApiGroupMapper groupDao;
    public void insertApiGroup(ApiGroup group)
    {
        groupDao.insertSelective(group);
    }

    /**
     *
     * @param id
     * @return
     */
    public ApiGroup getApiGroup(int id)
    {
        return groupDao.selectByPrimaryKey(id);
    }

    /**
     * 得到所有分组
     * @return
     */
    public List<ApiGroup>getGroupList(Integer pid)
    {
        ApiGroupExample example=new ApiGroupExample();
        example.createCriteria().andPidEqualTo(pid);
        return groupDao.selectByExample(example);
    }

    /**
     * 删除一个分组
     * @param id
     */
    public void deleteApiGroup(int id)
    {
        groupDao.deleteByPrimaryKey(id);
    }

    /**
     * 编辑一个分组
     * @param group
     */
    public void editApiGroup(ApiGroup group)
    {
        groupDao.updateByPrimaryKey(group);
    }
    public void deleteByProject(Integer pid)
    {
        ApiGroupExample example=new ApiGroupExample();
        example.createCriteria().andPidEqualTo(pid);
        groupDao.deleteByExample(example);
    }
}
