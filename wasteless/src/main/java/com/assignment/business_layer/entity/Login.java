package com.assignment.business_layer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Login implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    private int goal;

    @OneToMany(mappedBy = "loginFK")
    private List<Groceries> groceryLists;

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Groceries> getGroceryLists() {
        return groceryLists;
    }

    public void setGroceryLists(List<Groceries> groceryLists) {
        this.groceryLists = groceryLists;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
