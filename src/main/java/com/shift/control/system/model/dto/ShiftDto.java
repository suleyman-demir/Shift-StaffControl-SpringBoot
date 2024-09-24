package com.shift.control.system.model.dto;

import com.shift.control.system.model.ShiftEntity;

import java.util.Date;

public record ShiftDto (
        String shiftId,
        Date startDate,
        Date finishDate
){

    public ShiftEntity toShiftEntity() {
        ShiftEntity shift = new ShiftEntity();
        shift.setShiftId(this.shiftId());
        shift.setStartDate(this.startDate());
        shift.setFinishDate(this.finishDate());
        return shift;
    }


    public static ShiftDto fromShiftEntity(ShiftEntity shiftEntity){
        return new ShiftDto(shiftEntity.getShiftId(), shiftEntity.getStartDate(), shiftEntity.getFinishDate());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
