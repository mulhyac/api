package com.lip.api.core.model;

import java.util.List;

public class ApiGroup {
    private Integer id;

    private String name;

    private String title;



    private List<Api>apis;

    public ApiGroup(Integer id, String name, String title) {
        this.id = id;
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
    public List<Api> getApis() {
        return apis;
    }
    public void setApis(List<Api> apis) {
        this.apis = apis;
    }
}