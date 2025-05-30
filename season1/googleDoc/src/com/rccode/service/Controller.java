package com.rccode.service;

import com.rccode.enumeration.RoleType;
import com.rccode.model.Document;
import com.rccode.model.User;

public interface Controller {
    Document createDocument(String name, String content, String userName);
    User createUser(String userName);
    boolean addRole(String documentName, String userName, String roleUserName, RoleType roleType);
    Document editDocument(String documentName, String userName, String content);
    Document readDocument(String documentName, String userName);
}
