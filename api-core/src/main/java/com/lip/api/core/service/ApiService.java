package com.lip.api.core.service;

import com.lip.api.core.dao.ApiMapper;
import com.lip.api.core.model.Api;
import com.lip.api.core.model.ApiExample;
import com.lip.api.core.model.ApiGroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@Service
public class ApiService {
    @Autowired
    private ApiMapper apiDao;
    public List<Api>getApiList(Integer groupId)
    {
        ApiExample example=new ApiExample();
        example.createCriteria().andGroupIdEqualTo(groupId);
        return apiDao.selectByExample(example);
    }
    public void insertApi(Api api)
    {
        apiDao.insertSelective(api);
    }

    /**
     * 更新一个Api
     * @param api
     */
    public void updateApi(Api api)
    {
        apiDao.updateByPrimaryKey(api);
    }

    /**
     * 删除一个API
     * @param id
     */
    public void deleteApi(int id)
    {
        apiDao.deleteByPrimaryKey(id);
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
}
