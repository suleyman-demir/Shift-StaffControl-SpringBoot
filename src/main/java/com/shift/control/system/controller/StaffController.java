package com.shift.control.system.controller;
import com.shift.control.system.model.dto.StaffDto;
import com.shift.control.system.repository.StaffRepository;
import com.shift.control.system.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/staff")
public class StaffController {
    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    @PostMapping
    public ResponseEntity<Void> addStaff(@RequestBody StaffDto staffDto){
        logger.info("Received request to add staff: {}" , staffDto.getId());
    staffService.addStaff(staffDto);
    return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<StaffDto>> getAllStaff(){
        logger.info("Received request to get all staff");
        return ResponseEntity.ok(staffService.getAllStaff());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StaffDto> getStaff(@PathVariable String id) {
        logger.info("Received request to get staff with id: {}", id);
        StaffDto staffDto = staffService.getStaff(id); // id'yi metoda geçiyoruz
        return ResponseEntity.ok(staffDto);
    }

}
