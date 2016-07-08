package com.lip.api.core.model;

public class ApiMethod {
    private Integer mid;

    private String type;

    public ApiMethod(Integer mid, String type) {
        this.mid = mid;
        this.type = type;
    }

    public ApiMethod() {
        super();
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}