package com.shift.control.system.repository;

import com.shift.control.system.model.ShiftEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ShiftRepository extends MongoRepository<ShiftEntity,String> {
    Optional<ShiftEntity> findByShiftId(String shiftId);
}
