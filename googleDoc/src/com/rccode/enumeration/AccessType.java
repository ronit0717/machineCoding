package com.rccode.enumeration;

public enum AccessType {
    PRIVATE,
    PUBLIC {
        @Override
        public boolean isGlobalAccess() {
            return true;
        }
    };

    public boolean isGlobalAccess() {
        return false;
    }
}
