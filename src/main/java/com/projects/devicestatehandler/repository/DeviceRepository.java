package com.projects.devicestatehandler.repository;

import com.projects.devicestatehandler.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
