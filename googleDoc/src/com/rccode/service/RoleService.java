package com.rccode.service;

import com.rccode.enumeration.RoleType;
import com.rccode.model.Document;
import com.rccode.model.User;

public interface RoleService {
    boolean checkRole(Document document, String userName, RoleType roleType);
    boolean addRole(Document document, User user, RoleType roleType);
}
