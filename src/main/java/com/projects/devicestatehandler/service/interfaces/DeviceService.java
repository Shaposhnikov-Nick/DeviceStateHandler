package com.projects.devicestatehandler.service.interfaces;

import com.projects.devicestatehandler.entity.Device;

import java.util.List;
import java.util.Map;

public interface DeviceService {

    // получение списка всех устройств
    List<Device> getAllDevices();

    // добавление устройства
    void saveDevice(Device device);

    // получение устройства по id
    Device getDevice(int id);

    // удаление устройства по id
    void deleteDevice(int id);

    Map<String, Device> findDevicesByProjectId(int projectId);
}
