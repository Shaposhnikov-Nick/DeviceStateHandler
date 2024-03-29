package com.projects.devicestatehandler.entity;

import com.projects.devicestatehandler.model.SummaryInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "serial_number")
    private String serialNumber;

    // флаг, указывающий на наличие ошибок в устройстве
    @Transient
    private boolean hasErrors;

    // общая информация об ошибках устройства
    @Transient
    private SummaryInfo summaryInfo;
}
