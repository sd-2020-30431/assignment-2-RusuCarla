package com.assignment.business_layer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table
public class Groceries implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private int quantity;

    @NotNull
    private int calories;

    @NotNull
    private Timestamp purchase_date;

    @NotNull
    private Timestamp expiration_date;

    private Timestamp consumption_date;

    @ManyToOne
    @NotNull
    private Login loginFK;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Timestamp purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Timestamp getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Timestamp expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Timestamp getConsumption_date() {
        return consumption_date;
    }

    public void setConsumption_date(Timestamp consumption_date) {
        this.consumption_date = consumption_date;
    }

    public Login getLoginFK() {
        return loginFK;
    }

    public void setLoginFK(Login login) {
        this.loginFK = login;
    }

    public int getInterval(){
        return ((int) ((this.getExpiration_date().getTime() - this.getPurchase_date().getTime())/86400000));
    }

    public int getTotalCalories(){
        return this.getQuantity()*this.getCalories();
    }

    public int computeBurndownRate() {
        return this.getTotalCalories()/this.getInterval();
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", calories=" + calories +
                ", purchase_date=" + purchase_date +
                ", expiration_date=" + expiration_date +
                ", consumption_date=" + consumption_date +
                ", loginFK=" + loginFK +
                '}';
    }
}
