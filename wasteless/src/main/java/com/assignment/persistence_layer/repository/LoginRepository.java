package com.assignment.persistence_layer.repository;

import com.assignment.business_layer.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Login,Integer> {

    Login findByUsername(String username);
    Login findById(int id);

}
