package com.assignment.presentation_layer.dto;

import java.sql.Timestamp;

public class GroceriesDto {
    private String name;
    private int quantity;
    private int calories;
    private Timestamp purchaseDate;
    private Timestamp expirationDate;
    private Timestamp consumptionDate;
    private int rate;

    public GroceriesDto() {
    }

    public GroceriesDto(String name, int quantity, int calories, Timestamp purchaseDate, Timestamp expirationDate, Timestamp consumptionDate, int rate) {
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Timestamp getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Timestamp consumptionDate) {
        this.consumptionDate = consumptionDate;
    }
}
