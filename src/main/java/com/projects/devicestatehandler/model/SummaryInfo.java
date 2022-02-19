package com.projects.devicestatehandler.model;

import lombok.Data;

@Data
public class SummaryInfo {

    private int eventCount;

    private int warningCount;

    private int errorCount;
}
