package com.projects.devicestatehandler.service.interfaces;

import com.projects.devicestatehandler.entity.Project;

import java.util.List;

public interface ProjectService {

    // получение списка всех проектов и устройств
    List<Project> getAllProjects();
}
