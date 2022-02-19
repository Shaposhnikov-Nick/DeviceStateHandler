package com.projects.devicestatehandler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projects.devicestatehandler.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String projectName;

    @Transient
    private Status stats;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "projectId")
    private List<Device> devicesOfProject;

    @Transient
    private String[] devicesSerialNumber;
}
