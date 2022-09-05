package com.said.gwmon.dto;

import javax.validation.constraints.*;

public class UserMeasurementRequestDTO {

    @NotNull
    @DecimalMin(value = "0.01", message = "Gas value should be positive and greater than 0.01")
    @DecimalMax(value = "99999.99", message = "Gas value should not be greater than 99999.99")
    private Float gasM3;

    @NotNull
    @DecimalMin(value = "0.01", message = "Cold water value should be positive and greater than 0.01")
    @DecimalMax(value = "99999.99", message = "Cold water value should not be greater than 99999.99")
    private Float waterColdM3;

    @DecimalMin(value = "0.01", message = "Hot water value should be positive and greater than 0.01")
    @DecimalMax(value = "99999.99", message = "Hot water value should not be greater than 99999.99")
    private Float waterHotM3;

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
}
