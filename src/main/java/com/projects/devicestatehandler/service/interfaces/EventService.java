package com.projects.devicestatehandler.service.interfaces;

import com.projects.devicestatehandler.entity.Event;

import java.util.List;

public interface EventService {

    // получение списка событий устройства по id устройства
    List<Event> findEventByDeviceId(int id);
}
