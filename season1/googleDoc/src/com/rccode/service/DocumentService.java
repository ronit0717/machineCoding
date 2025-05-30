package com.rccode.service;

import com.rccode.model.Document;
import com.rccode.model.User;

public interface DocumentService {
    Document addDocument(String name, String content, User user);
    Document readDocument(String name, User user);
    Document editDocument(String name, String content, User user);
}
