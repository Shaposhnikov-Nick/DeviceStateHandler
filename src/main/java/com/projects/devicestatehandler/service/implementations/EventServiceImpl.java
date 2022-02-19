package com.projects.devicestatehandler.service.implementations;

import com.projects.devicestatehandler.entity.Event;
import com.projects.devicestatehandler.repository.EventRepository;
import com.projects.devicestatehandler.service.interfaces.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void saveEvent(Event event) {

    }

    @Override
    public Event getEvent(int id) {
        return null;
    }

    @Override
    public void deleteEvent(int id) {

    }

    @Override
    public List<Event> findEventByDeviceId(int id) {
        return eventRepository.findEventByDeviceId(id);
    }
}
