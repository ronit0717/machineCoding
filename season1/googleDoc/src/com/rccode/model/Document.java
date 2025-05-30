package com.rccode.model;

import com.rccode.enumeration.AccessType;
import com.rccode.service.util.DateUtil;
import com.rccode.service.util.RandomUtil;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Document {
    private String id;
    private String name;
    private String content;
    private List<Role> roles;
    private AccessType accessType;
    private User createdBy;
    private Date createdOn;
    private Date updatedOn;

    public Document(String name, String content, User createdBy) {
        this.id = RandomUtil.getRandomId();
        this.name = name;
        this.content = content;
        this.createdBy = createdBy;
        this.createdOn = DateUtil.getCurrentDate();
        this.updatedOn = DateUtil.getCurrentDate();
        this.roles = new LinkedList<>();
        this.accessType = AccessType.PRIVATE;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }
}
