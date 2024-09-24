package com.shift.control.system.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Entity
public class ShiftEntity {
    @Id
    @UuidGenerator
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String shiftId;
    private Date finishDate;
    private Date startDate;
    private String staffId;
    @JoinColumn(name = "staff_id", nullable = false)
    private StaffEntity staff;


    public ShiftEntity() {

    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }
}
