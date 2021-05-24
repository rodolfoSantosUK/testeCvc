package com.scheduling.Scheduling.enumeration;

public enum ErrorTransfer {

    ERROR_001 ("001", "The error has happend");

    ErrorTransfer(String id, String description) {
        this.id = id;
        this.description = description;
    }

    private String id;
    private String description;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
