package com.rccode.service.impl;

import com.rccode.service.CacheService;

import java.util.HashMap;
import java.util.Map;

public class CacheServiceImpl implements CacheService {

    Map<Object, Object> cache;

    public CacheServiceImpl() {
        this.cache = new HashMap<>();
    }

    @Override
    public void put(Object key, Object value) {
        cache.put(key, value);
    }

    @Override
    public Object get(Object key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return null;
    }
}
