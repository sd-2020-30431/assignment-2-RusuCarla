package com.assignment.business_layer.services;

import com.assignment.presentation_layer.dto.*;
import com.assignment.persistence_layer.repository.LoginRepository;
import com.assignment.persistence_layer.repository.*;
import com.assignment.business_layer.entity.Groceries;
import com.assignment.business_layer.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class GroceriesService {
    @Autowired
    GroceriesRepository groceriesRepository;
    @Autowired
    LoginRepository loginRepository;

    @Transactional
    public int addGroceries(GroceriesDto groceriesDto, int id) {
        Login login = loginRepository.findById(id);
        if (groceriesRepository.findByName(groceriesDto.getName()) != null)
            return -1;

        Groceries groceries =  new Groceries();
        groceries.setName(groceriesDto.getName());
        groceries.setQuantity(groceriesDto.getQuantity());
        groceries.setCalories(groceriesDto.getCalories());
        groceries.setPurchase_date(groceriesDto.getPurchaseDate());
        groceries.setExpiration_date(groceriesDto.getExpirationDate());
        groceries.setConsumption_date(groceriesDto.getConsumptionDate());

        groceries.setLoginFK(login);
        login.getGroceryLists().add(groceries);

        groceriesRepository.save(groceries);
        return 0;
    }

    @Transactional
    public int deleteGroceries(String name) {
        Groceries groceries = groceriesRepository.findByName(name);
        if (groceries == null)
            return -1;
        groceriesRepository.delete(groceries);
        return 0;
    }

    @Transactional
    public ArrayList<GroceriesDto>  getGroceries(int id) {
        ArrayList<GroceriesDto> groceriesDtos = new ArrayList<GroceriesDto>();
        Login login = loginRepository.findById(id);
        for (Groceries g : login.getGroceryLists()) {
            groceriesDtos.add(new GroceriesDto(g.getName(),g.getQuantity(),g.getCalories(),g.getPurchase_date(),
                    g.getExpiration_date(),g.getConsumption_date(),g.computeBurndownRate()));
        }
        return groceriesDtos;
    }

    @Transactional
    public int addConsumptionDate(ConsumptionDto consumptionDto,int id) {
        Login loginFK = loginRepository.findById(id);
        Groceries groceries = groceriesRepository.findByNameAndAndLoginFK(consumptionDto.getName(), loginFK);
        if (groceries == null)
            return -1;
        groceries.setConsumption_date(consumptionDto.getConsumptionDate());
        System.out.println(groceries.toString());
        groceriesRepository.save(groceries);
        return 0;
    }

    public ArrayList<Integer> getBurndownRates(int id){
        Login login = loginRepository.findById(id);
        ArrayList<Integer> rates = new ArrayList<>();
        for (Groceries g : login.getGroceryLists()) {
            rates.add(g.computeBurndownRate());
        }
        return rates;
    }

}
