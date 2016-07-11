package com.lip.api.core.service;

import com.lip.api.core.dao.ActivityMapper;
import com.lip.api.core.model.Activity;
import com.lip.api.core.model.ActivityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/11 0011.
 */
@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityDao;
    public List<Activity> getActivityList(Integer pid)
    {
        ActivityExample example=new ActivityExample();
        example.createCriteria().andProjectIdEqualTo(pid);
        return activityDao.selectByExample(example);
    }
    public  void insertActivity(Activity activity)
    {
        activity.setTime(new Date());
        activityDao.insertSelective(activity);
    }
}
