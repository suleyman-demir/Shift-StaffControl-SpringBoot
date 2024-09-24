package com.shift.control.system.service;

import com.shift.control.system.model.ShiftEntity;
import com.shift.control.system.model.StaffEntity;
import com.shift.control.system.model.dto.StaffDto;
import com.shift.control.system.repository.ShiftRepository;
import com.shift.control.system.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {
    private final StaffRepository staffRepository;
    private final ShiftRepository shiftRepository;

    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    public StaffService(StaffRepository staffRepository, ShiftRepository shiftRepository) {
        this.staffRepository = staffRepository;
        this.shiftRepository = shiftRepository;

    }

    public void addStaff(StaffDto staffDto){
        logger.info("Staff adding : {}",staffDto.getId());
        StaffEntity staffEntity = StaffDto.toEntity(staffDto);
        staffRepository.save(staffEntity);
        logger.info("Staff added successfully : {}",staffEntity.getId());
    }

    public StaffDto getStaff(String id) {
        logger.info("Getting staff by id : {}", id);
        StaffEntity staffEntity = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        return StaffDto.fromEntity(staffEntity);
    }

    public List <StaffDto> getAllStaff(){
        logger.info("Getting all staff");
        List<StaffEntity> staffEntities = staffRepository.findAll();
        return staffEntities.stream()
                .map(StaffDto::fromEntity)
                .collect(Collectors.toList());
    }



}
