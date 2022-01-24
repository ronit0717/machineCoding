package com.rccode.model;

import com.rccode.enumeration.RoleType;

public class Role {
    private User user;
    private RoleType roleType;

    public Role(User user, RoleType roleType) {
        this.user = user;
        this.roleType = roleType;
    }

    public User getUser() {
        return user;
    }

    public RoleType getRoleType() {
        return roleType;
    }
}
