package com.projects.devicestatehandler.model;

import lombok.Data;

@Data
public class Status {

    // общее количество устройств в проекте
    private int deviceCount;

    // количество устройств с ошибками за последние сутки
    private int deviceWithErrors;

    // количество стабильно работающих устройств
    private int stableDevices;
}
