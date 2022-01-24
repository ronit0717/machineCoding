package com.rccode.service.impl;

import com.rccode.enumeration.RoleType;
import com.rccode.model.Document;
import com.rccode.model.User;
import com.rccode.repository.RepositoryService;
import com.rccode.repository.RepositoryServiceImpl;
import com.rccode.service.*;

public class ControllerImpl implements Controller {

    private UserService userService;
    private DocumentService documentService;
    private CacheService cacheService;
    private RepositoryService repositoryService;
    private RoleService roleService;

    public ControllerImpl() {
        repositoryService = new RepositoryServiceImpl();
        cacheService = new CacheServiceImpl();
        userService = new UserServiceImpl(cacheService, repositoryService);
        roleService = new RoleServiceImpl();
        documentService = new DocumentServiceImpl(cacheService, repositoryService, roleService);
    }

    @Override
    public Document createDocument(String name, String content, String userName) {
        User user = userService.getUserByName(userName);
        return documentService.addDocument(name, content, user);
    }

    @Override
    public User createUser(String userName) {
        return userService.addUser(userName);
    }

    @Override
    public boolean addRole(String documentName, String creatorUserName, String roleUserName, RoleType roleType) {
        User creator = userService.getUserByName(creatorUserName);
        User roleUser = userService.getUserByName(roleUserName);
        Document document = documentService.readDocument(documentName, creator);
        return roleService.addRole(document, roleUser, roleType);
    }

    @Override
    public Document editDocument(String documentName, String userName, String content) {
        User user = userService.getUserByName(userName);
        return documentService.editDocument(documentName, content, user);
    }

    @Override
    public Document readDocument(String documentName, String userName) {
        User user = userService.getUserByName(userName);
        return documentService.readDocument(documentName, user);
    }
}
