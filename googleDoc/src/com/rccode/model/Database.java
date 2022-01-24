package com.rccode.model;

import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Document> documents;
    private List<User> users;

    public Database() {
        this.documents = new LinkedList<>();
        this.users = new LinkedList<>();
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
