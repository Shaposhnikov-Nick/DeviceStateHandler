package com.projects.devicestatehandler.controller;

import com.projects.devicestatehandler.entity.Device;
import com.projects.devicestatehandler.service.interfaces.DeviceService;
import com.projects.devicestatehandler.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DeviceService devicesService;

    @GetMapping("/projects/{projectId}/devices")
    public Map<String,Device> showAllDevicesOfProject(@PathVariable int projectId){
        return devicesService.findDevicesByProjectId(projectId);
    }
}
