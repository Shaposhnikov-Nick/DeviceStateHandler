package com.projects.devicestatehandler.service.implementations;

import com.projects.devicestatehandler.entity.Device;
import com.projects.devicestatehandler.entity.Project;
import com.projects.devicestatehandler.repository.DeviceRepository;
import com.projects.devicestatehandler.repository.ProjectRepository;
import com.projects.devicestatehandler.service.interfaces.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return null;
    }

    @Override
    public void saveDevice(Device device) {

    }

    @Override
    public Device getDevice(int id) {
        return null;
    }

    @Override
    public void deleteDevice(int id) {

    }

    @Override
    public Map<String, Device> findDevicesByProjectId(int projectId) {
        Map<String, Device> devicesOfProject = new HashMap<>();
        Project project = null;

        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent())
            project = optionalProject.get();

        List<Device> devices = project.getDevices();

        for (Device device : devices) {
            devicesOfProject.put(device.getSerialNumber(), device);
        }

        return devicesOfProject;
    }
}
