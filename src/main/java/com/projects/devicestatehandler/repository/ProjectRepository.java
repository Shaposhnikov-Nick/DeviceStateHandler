package com.projects.devicestatehandler.repository;

import com.projects.devicestatehandler.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
