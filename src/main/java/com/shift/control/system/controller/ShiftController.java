package com.shift.control.system.controller;

import com.shift.control.system.model.dto.ShiftDto;
import com.shift.control.system.model.dto.StaffDto;
import com.shift.control.system.service.ShiftService;
import com.shift.control.system.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/api/shift")
@RestController
public class ShiftController {
    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);
    private final StaffService staffService;
    private final ShiftService shiftService;

    public ShiftController(StaffService staffService, ShiftService shiftService) {
        this.staffService = staffService;
        this.shiftService = shiftService;
    }

    @PostMapping("/{staffId}/shifts")
    public ResponseEntity<ShiftDto> addShiftToStaff(@PathVariable String staffId, @RequestBody ShiftDto shiftDto) {
        logger.info("Request received to add shift for staff with id: {}", staffId);
        ShiftDto addedShift = shiftService.addShiftToStaff(staffId, shiftDto);
        return ResponseEntity.ok(addedShift);
    }

    @GetMapping("/{staffId}/shifts")
    public ResponseEntity<ShiftDto> getShift(@PathVariable String staffId, @RequestBody ShiftDto shiftDto) {
        logger.info("Request received to get shift for staff with id: {}", staffId);
        ShiftDto foundShift = shiftService.getShift(shiftDto);
        return ResponseEntity.ok(foundShift);

    }


}
