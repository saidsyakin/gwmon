package com.said.gwmon.service.impl;

import com.said.gwmon.domain.UserMeasurement;
import com.said.gwmon.dto.UserMeasurementDTO;
import com.said.gwmon.dto.UserMeasurementRequestDTO;
import com.said.gwmon.dto.UserMeasurementsPageDTO;
import com.said.gwmon.repository.UserMeasurementRepository;
import com.said.gwmon.service.UserMeasurementsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserUserMeasurementsServiceImpl implements UserMeasurementsService {

    UserMeasurementRepository userMeasurementRepository;

    ModelMapper modelMapper;

    @Autowired
    public UserUserMeasurementsServiceImpl(UserMeasurementRepository userMeasurementRepository, ModelMapper modelMapper) {
        this.userMeasurementRepository = userMeasurementRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserMeasurementsPageDTO getMeasurements(UUID userId, Pageable pageable) {
        return
                modelMapper.map(userMeasurementRepository.getAllByUserId(userId, pageable)
                        .map(it -> modelMapper.map(it, UserMeasurementDTO.class)), UserMeasurementsPageDTO.class);
    }

    @Override
    public void setMeasurement(UUID userId, UserMeasurementRequestDTO userMeasurementDTO) {
        UserMeasurement userMeasurement = modelMapper.map(userMeasurementDTO, UserMeasurement.class);
        userMeasurement.setUserId(userId);
        userMeasurementRepository.save(userMeasurement);
    }
}
