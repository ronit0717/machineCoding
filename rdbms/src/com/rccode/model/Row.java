package com.rccode.model;

import com.rccode.enumeration.Constraint;
import com.rccode.service.util.DateUtil;
import com.rccode.service.util.RandomUtil;

import java.util.*;

public class Row {

    private String rowId;
    private Map<String, Column> columnMap;
    private String primaryKey;
    private List<String> uniqueKeys;
    private Date createdAt;
    private Date updatedAt;

    public Row(HashMap<String, Column> column) {
        this.rowId = RandomUtil.getRandomId();
        this.columnMap = column;
        this.createdAt = DateUtil.getCurrentDate();
        this.updatedAt = DateUtil.getCurrentDate();
    }

    public String getPrimaryKeyValue() {
        for(Iterator<Map.Entry<String, Column>> it = columnMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Column> entry = it.next();
            if(Constraint.PRIMARY_KEY.equals(entry.getValue().getConstraint())) {
                return entry.getValue().getValue();
            }
        }
        return null;
    }

    public Map<String, Column> getColumnMap() {
        return columnMap;
    }

    public void updateUpdatedAt() {
        this.updatedAt = DateUtil.getCurrentDate();
    }
}
