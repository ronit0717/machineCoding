package com.rccode.service.impl;

import com.rccode.enumeration.RoleType;
import com.rccode.model.Document;
import com.rccode.model.Role;
import com.rccode.model.User;
import com.rccode.service.RoleService;

public class RoleServiceImpl implements RoleService {

    @Override
    public boolean checkRole(Document document, String userName, RoleType roleType) {
        if (document.getAccessType().isGlobalAccess()) {
            return true;
        }
        if (document.getCreatedBy().getName().equals(userName)) {
            return true;
        }
        for (Role role : document.getRoles()) {
            if (role.getUser().getName().equals(userName) && role.getRoleType().equals(roleType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addRole(Document document, User user, RoleType roleType) {
        boolean existingRole = checkRole(document, user.getName(), roleType);
        if (existingRole) {
            return false;
        }
        Role role = new Role(user, roleType);
        document.addRole(role);
        return true;
    }
}
