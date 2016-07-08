package com.lip.api.core.service;

import com.lip.api.core.dao.ApiGroupMapper;
import com.lip.api.core.model.ApiGroup;
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
    public List<ApiGroup>getGroupList()
    {
        return groupDao.selectByExample(null);
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
}
