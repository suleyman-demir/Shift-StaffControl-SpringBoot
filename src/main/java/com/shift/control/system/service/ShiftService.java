package com.shift.control.system.service;

import com.shift.control.system.model.ShiftEntity;
import com.shift.control.system.model.StaffEntity;
import com.shift.control.system.model.dto.ShiftDto;
import com.shift.control.system.repository.ShiftRepository;
import com.shift.control.system.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShiftService {
    private final ShiftRepository shiftRepository;
    private final StaffRepository staffRepository;

    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    public ShiftService(ShiftRepository shiftRepository, StaffRepository staffRepository) {
        this.shiftRepository = shiftRepository;
        this.staffRepository = staffRepository;
    }

    public ShiftDto addShiftToStaff(String staffId, ShiftDto shiftDto) {
        logger.info("Adding shift to staff with id: {}", staffId);

        // StaffEntity'yi bul
        StaffEntity staffEntity = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + staffId));

        // ShiftEntity'yi DTO'dan oluştur
        ShiftEntity shiftEntity = shiftDto.toShiftEntity();
        shiftEntity.setStaff(staffEntity);  // Shift'i ilgili staff ile ilişkilendir

        // ShiftEntity'yi kaydet
        ShiftEntity savedShiftEntity = shiftRepository.save(shiftEntity);

        // DTO'yu geri döndür
        return ShiftDto.fromShiftEntity(savedShiftEntity);
    }
    public ShiftDto getShift(ShiftDto shiftDto){
        logger.info("Staff getting : {}",shiftDto.shiftId());
        ShiftEntity shiftEntity = shiftRepository.findById(shiftDto.shiftId())
               .orElseThrow(() -> new RuntimeException("Shift not found"));
        return shiftDto.fromShiftEntity(shiftEntity);
    }

}
