package com.projects.devicestatehandler.service.interfaces;

import com.projects.devicestatehandler.entity.Device;

import java.util.Map;

public interface DeviceService {

    // получение списка устройств по id проекта
    Map<String, Device> findDevicesByProjectId(int projectId);
}
