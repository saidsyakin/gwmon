package com.said.gwmon.domain;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "user_measurements",
        indexes = {
                @Index(columnList = "user_id"),
                @Index(columnList = "created_date"),
        })
public class UserMeasurement extends Measurement {

    @Column(name = "gas_m3", nullable = false)
    @NotNull
    private Float gasM3;

    @Column(name = "water_cold_m3", nullable = false)
    @NotNull
    private Float waterColdM3;

    @Column(name = "water_hot_m3")
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

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return ((UserMeasurement) o).getId().equals(this.id);
    }
}
