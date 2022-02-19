package com.projects.devicestatehandler.service.implementations;

import com.projects.devicestatehandler.entity.Device;
import com.projects.devicestatehandler.entity.Event;
import com.projects.devicestatehandler.entity.Project;
import com.projects.devicestatehandler.model.Status;
import com.projects.devicestatehandler.repository.ProjectRepository;
import com.projects.devicestatehandler.service.interfaces.EventService;
import com.projects.devicestatehandler.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EventService eventService;

    @Override
    public List<Project> getAllProjects() {

        // получение список всех проектов
        List<Project> projects = projectRepository.findAll();

        // проверка всех устройств проекта на тип сигналов
        for (Project project : projects) {

            // статус устройств
            Status status = new Status();

            // общее количество устройств в проекте
            int deviceCount;

            // количество устройств с ошибками и предупреждениями
            int deviceWithErrors = 0;

            // количество устройств без ошибок
            int stableDevice = 0;

            // получение списка устройств каждого проекта
            List<Device> devicesOfProject = project.getDevicesOfProject();

            // получение массива с серийными номерами устройств
            String[] devicesSerialNumber = new String[devicesOfProject.size()];

            for (int i = 0; i < devicesOfProject.size(); i++) {
                devicesSerialNumber[i] = devicesOfProject.get(i).getSerialNumber();
            }

            // количество устройств в проекте
            deviceCount = devicesOfProject.size();

            // проверка каждого устройства на наличие сигналов
            for (Device device : devicesOfProject) {

                boolean isStableDevice;

                boolean hasError;

                boolean hasWarning;


                // получаение списка событий каждого устройства
                List<Event> events = eventService.findEventByDeviceId(device.getId());

                // устройство за последние сутки имело ошибку ERROR или WARNING
                hasError = events.stream().filter(x -> x.getDate().equals(LocalDate.now().minusDays(1)))
                        .anyMatch(x -> x.getEventType().getType().equalsIgnoreCase("ERROR"));

                hasWarning = events.stream().filter(x -> x.getDate().equals(LocalDate.now().minusDays(1)))
                        .anyMatch(x -> x.getEventType().getType().equalsIgnoreCase("WARNING"));

                if (hasError || hasWarning)
                    deviceWithErrors++;


                //Стабильно работающее устройство (для которого в таблице events есть только записи у которых
                // поле type = 'event')
                isStableDevice = events.stream().allMatch(x -> x.getEventType().getType()
                        .equalsIgnoreCase("EVENT"));

                if (isStableDevice)
                    stableDevice++;
            }

            // запись данных о сигналах
            status.setStableDevices(stableDevice);
            status.setDeviceCount(deviceCount);
            status.setDeviceWithErrors(deviceWithErrors);

            // запись данных об устройствах
            project.setStats(status);
            project.setDevicesSerialNumber(devicesSerialNumber);
        }

        return projects;
    }
}
