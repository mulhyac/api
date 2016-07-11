package com.lip.api.core.model;

import com.alibaba.fastjson.JSONArray;

import java.util.Date;

public class Api {
    private Integer id;

    private Integer groupId;

    private String name;

    private String brief;

    private String url;

    private String method;

    private String output;

    private String parameter;

    private String remark;

    private Date updateTime;

    private Date createTime;
    private JSONArray params;

    public Api(Integer id, Integer groupId, String name, String brief, String url, String method, String output, String parameter, String remark, Date updateTime, Date createTime) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.brief = brief;
        this.url = url;
        this.method = method;
        this.output = output;
        this.parameter = parameter;
        this.remark = remark;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public Api() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output == null ? null : output.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public  JSONArray getParams()
        {
            return  JSONArray.parseArray(parameter);
        }
}