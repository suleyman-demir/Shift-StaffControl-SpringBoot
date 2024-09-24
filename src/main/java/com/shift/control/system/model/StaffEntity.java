package com.shift.control.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

@Entity
public class StaffEntity {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;
    private String department;
    private String salary;

    public StaffEntity(String id, String name, String department, String salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public StaffEntity() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}