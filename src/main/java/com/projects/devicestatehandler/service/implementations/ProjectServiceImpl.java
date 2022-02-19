package com.projects.devicestatehandler.service.implementations;

import com.projects.devicestatehandler.entity.Device;
import com.projects.devicestatehandler.entity.Project;
import com.projects.devicestatehandler.repository.ProjectRepository;
import com.projects.devicestatehandler.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public void saveProject(Device device) {

    }

    @Override
    public Project getProject(int id) {
        Project project = null;
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent())
            project = optionalProject.get();

        return project;
    }

    @Override
    public void deleteProject(int id) {

    }
}
