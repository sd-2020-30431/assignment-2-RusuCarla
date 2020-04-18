package com.assignment.presentation_layer.dto;

import java.sql.Timestamp;

public class ConsumptionDto {
    private String name;
    private Timestamp consumptionDate;

    public ConsumptionDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Timestamp consumptionDate) {
        this.consumptionDate = consumptionDate;
    }
}
