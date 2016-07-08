package com.lip.api.core.model;

import java.util.Date;

public class ApiInterface {
    private Integer aid;

    private Integer cid;

    private String url;

    private String method;

    private String description;

    private Date addTime;

    private Date updateTime;

    public ApiInterface(Integer aid, Integer cid, String url, String method, String description, Date addTime, Date updateTime) {
        this.aid = aid;
        this.cid = cid;
        this.url = url;
        this.method = method;
        this.description = description;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public ApiInterface() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}