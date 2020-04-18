package com.assignment.utilities.validators;

import com.assignment.presentation_layer.dto.ConsumptionDto;
import com.assignment.presentation_layer.dto.GroceriesDto;
import com.assignment.presentation_layer.dto.LoginDto;

import java.sql.Timestamp;

public class Validator {

    public static boolean validateConsumptionDto(ConsumptionDto consumptionDto) {
        if (consumptionDto != null) {
            if (Validator.isName(consumptionDto.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateGroceriesDto(GroceriesDto groceriesDto) {
        if (groceriesDto != null) {
            if (Validator.isName(groceriesDto.getName())) {
                if (Validator.isStrictlyPositive(groceriesDto.getCalories()))
                    if (Validator.isStrictlyPositive(groceriesDto.getQuantity()))
                        if (Validator.validDates(groceriesDto.getPurchaseDate(),groceriesDto.getExpirationDate()))
                            return true;
            }
        }
        return false;
    }

    public static boolean validateLoginDto(LoginDto loginDto) {
        if (loginDto != null) {
            if (Validator.isAlphanumeric(loginDto.getUsername())) {
                if(Validator.isAlphanumeric(loginDto.getPassword()))
                    return true;
            }
        }
        return false;
    }

    public static boolean validateGoal(int goal) {
        if (Validator.isStrictlyPositive(goal))
            return true;
        return false;
    }

    private static boolean isNumeric(String string){
        return string.matches("[0-9]+");
    }

    private static boolean isAlpha(String string){
        return string.matches("[a-zA-Z]+");
    }

    private static boolean isName(String name) {
        return name.matches("^[ A-Za-z]+$");
    }

    private static boolean isAlphanumeric(String string) {
        return string.matches("[A-Za-z0-9]+");
    }

    private static boolean validDates(Timestamp purchaseDate, Timestamp expirationDate){
        return (purchaseDate.getTime()<expirationDate.getTime());
    }

    private static boolean isStrictlyPositive(int i){
        return (i>0);
    }
}
