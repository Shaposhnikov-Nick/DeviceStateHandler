package com.projects.devicestatehandler.enums;

public enum EventType {
    EVENT("event"),
    WARNING("warning"),
    ERROR("error");

    private String type;

    EventType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
