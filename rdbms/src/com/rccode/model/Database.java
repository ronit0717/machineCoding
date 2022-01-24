package com.rccode.model;

import com.rccode.exception.ProcessException;
import com.rccode.service.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private String name;
    private Map<String, Table> tableMap;
    private Date createdAt;

    public Database(String name) {
        this.name = name;
        this.tableMap = new HashMap<>();
        this.createdAt = DateUtil.getCurrentDate();
    }

    public Table createTable(String tableName) {
        if (tableMap.containsKey(tableName)) {
            throw new ProcessException("Create Table", "Duplicate Table Name");
        }
        Table table = new Table(tableName);
        tableMap.put(tableName, table);
        System.out.println("Table successfully created");
        return table;
    }

    public void dropTable(String tableName) {
        if (!tableMap.containsKey(tableName)) {
            throw new ProcessException("Drop Table", "Invalid Table Name");
        }
        tableMap.remove(tableName);
        System.out.println("Table successfully dropped");
    }

    public String getName() {
        return name;
    }

    public Map<String, Table> getTableMap() {
        return tableMap;
    }
}
