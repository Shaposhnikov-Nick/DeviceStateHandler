package com.projects.devicestatehandler.model;

import lombok.Data;

@Data
public class SummaryInfo {

    // количество событий на устройстве
    private int eventCount;

    // количество предупреждений на устройстве
    private int warningCount;

    // количество ошибок на устройстве
    private int errorCount;
}
