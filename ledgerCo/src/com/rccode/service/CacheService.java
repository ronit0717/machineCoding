package com.rccode.service;

public interface CacheService {
    void put(Object key, Object value);
    Object get(Object key);
}
