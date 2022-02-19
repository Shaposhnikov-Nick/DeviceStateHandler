package com.projects.devicestatehandler.repository;

import com.projects.devicestatehandler.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findEventByDeviceId(int id);
}
