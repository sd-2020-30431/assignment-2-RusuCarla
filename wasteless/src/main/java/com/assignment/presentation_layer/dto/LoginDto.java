package com.assignment.presentation_layer.dto;

public class LoginDto {
    private String username;
    private String password;
    private int goal;

    public LoginDto() {
    }

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

    @Override
    public String toString() {
        return "LoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", goal=" + goal +
                '}';
    }
}
