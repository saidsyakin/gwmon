package com.said.gwmon.service;

import com.said.gwmon.dto.UserMeasurementRequestDTO;
import com.said.gwmon.dto.UserMeasurementsPageDTO;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserMeasurementsService {

    UserMeasurementsPageDTO getMeasurements(UUID userId, Pageable pageable);

    void setMeasurement(UUID userId, UserMeasurementRequestDTO userMeasurementDTO);

}
