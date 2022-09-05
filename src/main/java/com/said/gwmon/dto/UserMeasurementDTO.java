package com.said.gwmon.dto;

import java.time.Instant;
import java.util.UUID;

public class UserMeasurementDTO {

    private UUID userId;

    private Float gasM3;

    private Float waterColdM3;

    private Float waterHotM3;

    private Instant createdDate;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Float getGasM3() {
        return gasM3;
    }

    public void setGasM3(Float gasM3) {
        this.gasM3 = gasM3;
    }

    public Float getWaterColdM3() {
        return waterColdM3;
    }

    public void setWaterColdM3(Float waterColdM3) {
        this.waterColdM3 = waterColdM3;
    }

    public Float getWaterHotM3() {
        return waterHotM3;
    }

    public void setWaterHotM3(Float waterHotM3) {
        this.waterHotM3 = waterHotM3;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
