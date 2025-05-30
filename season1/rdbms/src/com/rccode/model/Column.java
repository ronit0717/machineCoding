package com.rccode.model;

import com.rccode.enumeration.Constraint;

public class Column {
    private String value;
    private Constraint constraint;

    public Column(String value, Constraint constraint) {
        this.value = value;
        this.constraint = constraint;
    }

    public String getValue() {
        return value;
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
