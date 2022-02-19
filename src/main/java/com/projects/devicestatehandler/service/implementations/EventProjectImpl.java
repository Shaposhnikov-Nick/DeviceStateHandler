package com.projects.devicestatehandler.service.implementations;

import com.projects.devicestatehandler.entity.Device;
import com.projects.devicestatehandler.service.interfaces.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventProjectImpl implements EventService {
    @Override
    public List<Device> getAllEvents() {
        return null;
    }

    @Override
    public void saveEvent(Device device) {

    }

    @Override
    public Device getEvent(int id) {
        return null;
    }

    @Override
    public void deleteEvent(int id) {

    }
}
