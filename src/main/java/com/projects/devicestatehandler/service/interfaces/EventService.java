package com.projects.devicestatehandler.service.interfaces;

import com.projects.devicestatehandler.entity.Event;

import java.util.List;

public interface EventService {

    // получение списка всех событий
    List<Event> getAllEvents();

    // добавление сбытия
    void saveEvent(Event event);

    // получение события по id
    Event getEvent(int id);

    // удаление события по id
    void deleteEvent(int id);

    List<Event> findEventByDeviceId(int id);
}
