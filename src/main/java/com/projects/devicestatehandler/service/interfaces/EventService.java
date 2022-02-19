package com.projects.devicestatehandler.service.interfaces;

import com.projects.devicestatehandler.entity.Device;

import java.util.List;

public interface EventService {

    // получение списка всех событий
    List<Device> getAllEvents();

    // добавление сбытия
    void saveEvent(Device device);

    // получение события по id
    Device getEvent(int id);

    // удаление события по id
    void deleteEvent(int id);
}
