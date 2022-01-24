package com.rccode.dto;

import com.rccode.enumeration.Gender;

public class AddUserRequest {
    private String name;
    private Gender gender;
    private String mobile;
    private String pincode;

    public AddUserRequest(String name, Gender gender, String mobile, String pincode) {
        this.name = name;
        this.gender = gender;
        this.mobile = mobile;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPincode() {
        return pincode;
    }
}
