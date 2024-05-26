package com.internal.bms.hr.hrportal.entity;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "jobpackage")
public class JobPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "packageid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    @ApiModelProperty(value = "ID of the job role", required = true)
    @NotNull(message = "Job Role is required")
    private JobRole role;

    @ManyToOne
    @JoinColumn(name = "departmentid", nullable = false)
    @ApiModelProperty(value = "ID of the job role", required = true)
    @NotNull(message = "Department is required")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "locationid", nullable = false)
    @ApiModelProperty(value = "ID of the job role", required = true)
    @NotNull(message = "location is required")
    private Location location;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobRole getRole() {
        return role;
    }

    public void setRole(JobRole role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
