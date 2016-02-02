package com.sjw.web.controller;

public class TabTrustedServerRequest {

    public TabTrustedServerRequest(){}
    public TabTrustedServerRequest(String username) {
        this.username = username;
    }
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String toString() {
        return username == null ? "No username" : username;
    }
}
