package com.said.gwmon.repository;

import com.said.gwmon.domain.UserMeasurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserMeasurementRepository extends JpaRepository<UserMeasurement, UUID> {

    Page<UserMeasurement> getAllByUserId(UUID userId, Pageable pageable);

}
