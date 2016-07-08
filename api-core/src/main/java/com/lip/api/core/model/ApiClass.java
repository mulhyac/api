package com.lip.api.core.model;

public class ApiClass {
    private Integer cid;

    private Integer pcid;

    private Integer lcid;

    private String name;

    public ApiClass(Integer cid, Integer pcid, Integer lcid, String name) {
        this.cid = cid;
        this.pcid = pcid;
        this.lcid = lcid;
        this.name = name;
    }

    public ApiClass() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public Integer getLcid() {
        return lcid;
    }

    public void setLcid(Integer lcid) {
        this.lcid = lcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}