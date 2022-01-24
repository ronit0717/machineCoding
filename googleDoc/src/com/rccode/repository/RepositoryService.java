package com.rccode.repository;

import com.rccode.model.Document;
import com.rccode.model.User;

public interface RepositoryService {
    User getUserByName(String userName);
    void addUser(User user);
    Document getDocument(String docName);
    void addDocument(Document document);
}
