package com.projects.devicestatehandler.model;

import lombok.Data;

@Data
public class Status {

    private int deviceCount;

    private int deviceWithErrors;

    private int stableDevices;
}
