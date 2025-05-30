package com.rccode.dto;

public class AddUserRequest {
    private String name;
    private String profession;

    public AddUserRequest(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }
}
