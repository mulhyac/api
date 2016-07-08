package com.lip.api.core.service;

import com.lip.api.core.dao.ApiMethodMapper;
import com.lip.api.core.model.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@Service
public class ApiMethodService {
    @Autowired
    private ApiMethodMapper apiDao;
    public void insertApiMethod(ApiMethod method)
    {
        apiDao.insert(method);
    }

    /**
     *
     * @param id
     * @return
     */
    public ApiMethod getMethod(int id)
    {
        return apiDao.selectByPrimaryKey(id);
    }
}
