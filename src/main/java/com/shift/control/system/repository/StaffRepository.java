package com.shift.control.system.repository;

import com.shift.control.system.model.StaffEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface StaffRepository extends MongoRepository<StaffEntity,String> {
    Optional<StaffEntity> findById(String id);
}
