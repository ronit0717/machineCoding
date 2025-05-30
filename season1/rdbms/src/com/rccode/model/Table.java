package com.rccode.model;

import com.rccode.exception.ProcessException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Table {
    private String name;
    private Map<String, Row> rowMap;

    public Table(String name) {
        this.name = name;
        this.rowMap = new HashMap<>();
    }

    public void addRow(String rowId, HashMap<String, Column> columnsMap) {
        if (rowMap.containsKey(rowId)) {
            throw new ProcessException("Add Row", "Duplicate Row ID");
        } else {
            Row row =  new Row(columnsMap);
            rowMap.put(rowId, row);
            System.out.println("Successfully added a row");
        }
    }

    public void updateEntry(String rowId, HashMap<String, String>valuesMap) {
        if (!rowMap.containsKey(rowId)) {
            throw new ProcessException("Update Row", "Invalid Row ID");
        }
        Row row = rowMap.get(rowId);
        Map<String, Column> columnMap = row.getColumnMap();
        for(Iterator<Map.Entry<String, String>> it = valuesMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            columnMap.get(entry.getKey()).setValue(entry.getValue());
        }
        row.updateUpdatedAt();
        System.out.println("Row successfully updated");
    }

    public void deleteRow(String rowId) {
        System.out.println("Row successfully deleted");
        rowMap.remove(rowId);
    }

    public Row getRow(String rowId) {
        return rowMap.get(rowId);
    }
}
