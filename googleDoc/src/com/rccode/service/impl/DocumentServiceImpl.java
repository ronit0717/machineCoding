package com.rccode.service.impl;

import com.rccode.enumeration.RoleType;
import com.rccode.exception.ProcessException;
import com.rccode.model.Document;
import com.rccode.model.User;
import com.rccode.repository.RepositoryService;
import com.rccode.service.CacheService;
import com.rccode.service.DocumentService;
import com.rccode.service.RoleService;

import javax.print.Doc;

public class DocumentServiceImpl implements DocumentService {

    private CacheService cacheService;
    private RepositoryService repositoryService;
    private RoleService roleService;

    private final String KEY_PREFIX = "DOC_";

    public DocumentServiceImpl(CacheService cacheService, RepositoryService repositoryService, RoleService roleService) {
        this.cacheService = cacheService;
        this.repositoryService = repositoryService;
        this.roleService = roleService;
    }

    @Override
    public Document addDocument(String name, String content, User user) {
        Document document = readDocument(name, user);
        if (document != null) {
            throw new ProcessException("Add Document", "Document already exists with given name");
        }
        document = new Document(name, content, user);
        repositoryService.addDocument(document);
        return document;
    }

    @Override
    public Document readDocument(String name, User user) {
        String key = KEY_PREFIX + name;
        Document document = (Document)cacheService.get(key);
        if (document == null) {
            document = repositoryService.getDocument(name);
            if (document == null) {
                return null;
            }
            cacheService.put(key, document);
        }
        checkAccess(document, user,RoleType.READ);
        printDocument(document);
        return document;
    }

    private void checkAccess(Document document, User user, RoleType roleType) {
        if (!roleService.checkRole(document, user.getName(), roleType)) {
            throw new ProcessException("Role Check", "Invalid Access");
        }
    }

    @Override
    public Document editDocument(String name, String content, User user) {
        Document document = repositoryService.getDocument(name);
        if (document == null) {
            throw new ProcessException("Add Document", "Document does not exist with given name");
        }
        checkAccess(document, user, RoleType.EDIT);
        document.setContent(content);
        return document;
    }

    private void printDocument(Document document) {
        System.out.println(document.getName() + " - " + document.getContent());
    }
}
