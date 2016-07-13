package com.lip.api.core.model;

public class User {
    private String name;

    private String email;

    private String password;

    private String gravater;

    public User(String name, String email, String password, String gravater) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gravater = gravater;
    }

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGravater() {
        return gravater;
    }

    public void setGravater(String gravater) {
        this.gravater = gravater == null ? null : gravater.trim();
    }
}