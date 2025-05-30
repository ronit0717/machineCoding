package com.rccode.dto;

public class UserLoginRequest {
    private String mobile;

    public UserLoginRequest(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }
}
