package com.projects.devicestatehandler.service.implementations;

import com.projects.devicestatehandler.entity.Device;
import com.projects.devicestatehandler.entity.Event;
import com.projects.devicestatehandler.entity.Project;
import com.projects.devicestatehandler.model.SummaryInfo;
import com.projects.devicestatehandler.repository.ProjectRepository;
import com.projects.devicestatehandler.service.interfaces.DeviceService;
import com.projects.devicestatehandler.service.interfaces.EventService;
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
    private EventService eventService;

    @Override
    public Map<String, Device> findDevicesByProjectId(int projectId) {

        Map<String, Device> devicesOfProject = new HashMap<>();

        Project project = null;

        // получение проекта по id
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent())
            project = optionalProject.get();

        // получение списка устройств проекта
        List<Device> devices = project.getDevicesOfProject();

        // получение количества событий на устройстве
        for (Device device : devices) {

            int eventCount = 0;

            int warningCount = 0;

            int errorCount = 0;

            boolean hasErrors = false;

            SummaryInfo summaryInfo = new SummaryInfo();

            List<Event> events = eventService.findEventByDeviceId(device.getId());

            for (Event event : events) {

                //подсчет количества событий на устройстве
                eventCount = (int) events.stream().filter(x -> x.getEventType().getType()
                        .equalsIgnoreCase("EVENT")).count();

                //подсчет количества предупреждений на устройстве
                warningCount = (int) events.stream().filter(x -> x.getEventType().getType()
                        .equalsIgnoreCase("WARNING")).count();

                //подсчет количества ошибок на устройстве
                errorCount = (int) events.stream().filter(x -> x.getEventType().getType()
                        .equalsIgnoreCase("ERROR")).count();

                // если есть ошибки на устройстве, устанавливаем флаг true
                if (errorCount > 0)
                    hasErrors = true;
            }

            // запись полученых значений событий в summaryInfo
            summaryInfo.setEventCount(eventCount);
            summaryInfo.setWarningCount(warningCount);
            summaryInfo.setErrorCount(errorCount);

            // запись полученных значений в device
            device.setSummaryInfo(summaryInfo);
            device.setHasErrors(hasErrors);

            devicesOfProject.put(device.getSerialNumber(), device);
        }

        return devicesOfProject;
    }
}