package com.shift.control.system.model.dto;
import com.shift.control.system.model.StaffEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaffDto {
    private String id;
    private String name;
    private String department;
    private String salary;



        public static StaffEntity toEntity (StaffDto dto) {
            StaffEntity staff = new StaffEntity();
            staff.setId(staff.getId());
            staff.setName(staff.getName());
            staff.setDepartment(staff.getDepartment());
            staff.setSalary(staff.getSalary());
            return staff;

        }
        public static StaffDto fromEntity (StaffEntity entity){
        StaffDto staffDto = new StaffDto();
        staffDto.setId(entity.getId());
        staffDto.setName(entity.getName());
        staffDto.setDepartment(entity.getDepartment());
        staffDto.setSalary(entity.getSalary());

        return staffDto;



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
