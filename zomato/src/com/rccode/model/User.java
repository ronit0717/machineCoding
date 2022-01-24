package com.rccode.model;

import com.rccode.dto.AddUserRequest;
import com.rccode.enumeration.Gender;

public class User {
    private String name;
    private Gender gender;
    private String phoneNumber;
    private String pincode;

    public User(AddUserRequest request) {
        this.name = request.getName();
        this.phoneNumber = request.getMobile();
        this.gender = request.getGender();
        this.pincode = request.getPincode();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPincode() {
        return pincode;
    }
}
