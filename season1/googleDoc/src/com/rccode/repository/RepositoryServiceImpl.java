package com.rccode.repository;

import com.rccode.model.Database;
import com.rccode.model.Document;
import com.rccode.model.User;

import java.util.List;

public class RepositoryServiceImpl implements RepositoryService {

    private Database database;

    public RepositoryServiceImpl() {
        this.database = new Database();
    }

    @Override
    public User getUserByName(String userName) {
        List<User> users = database.getUsers();
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        database.addUser(user);
    }

    @Override
    public Document getDocument(String docName) {
        List<Document> documents = database.getDocuments();
        for (Document document : documents) {
            if (document.getName().equals(docName)) {
                return document;
            }
        }
        return null;
    }

    @Override
    public void addDocument(Document document) {
        database.addDocument(document);
    }
}
