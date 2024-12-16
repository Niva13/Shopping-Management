package com.example.shoppingmanagement.models;

public class User {

    private String phone;
    private String email;



    public User(String phone, String email) {
        this.phone = phone;
        this.email = email;

    }

    public User() {
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
