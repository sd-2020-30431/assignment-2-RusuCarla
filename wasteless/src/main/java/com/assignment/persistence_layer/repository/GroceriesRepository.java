package com.assignment.persistence_layer.repository;

import com.assignment.business_layer.entity.Groceries;
import com.assignment.business_layer.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroceriesRepository extends JpaRepository<Groceries,Integer> {
    Groceries findByNameAndAndLoginFK(String name, Login loginFK);
    Groceries findByName(String name);
}
