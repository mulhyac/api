package com.lip.api.core.model;

public class ApiParameter {
    private Integer pid;

    private Integer aid;

    private String name;

    private String type;

    private String description;

    public ApiParameter(Integer pid, Integer aid, String name, String type, String description) {
        this.pid = pid;
        this.aid = aid;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public ApiParameter() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}