package com.lip.api.core.model;

import java.util.List;

public class ApiGroup {
    private Integer id;

    private Integer pid;

    private String name;

    private String title;
    private List<Api>apis;

    public ApiGroup(Integer id, Integer pid, String name, String title) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.title = title;
    }

    public ApiGroup() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    public void setApis(List<Api>apis)
    {
        this.apis=apis;
    }
    public List<Api>getApis()
    {
        return apis;
    }
}