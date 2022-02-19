package com.projects.devicestatehandler.service.interfaces;

import com.projects.devicestatehandler.entity.Device;
import com.projects.devicestatehandler.entity.Project;

import java.util.List;

public interface ProjectService {

    // получение списка всех проектов и устройств
    List<Project> getAllProjects();

    // добавление проекта
    void saveProject(Device device);

    // получение проекта по id
    Project getProject(int id);

    // удаление проекта по id
    void deleteProject(int id);
}
