package com.lip.api.core.model;

import java.util.Date;

public class Activity {
    private Integer id;

    private Integer projectId;

    private String userId;

    private Integer apiId;

    private String apiName;

    private String brief;

    private String action;

    private Date time;

    public Activity(Integer id, Integer projectId, String userId, Integer apiId, String apiName, String brief, String action, Date time) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.apiId = apiId;
        this.apiName = apiName;
        this.brief = brief;
        this.action = action;
        this.time = time;
    }

    public Activity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}