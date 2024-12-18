package com.example.shoppingmanagement.models;

public class User {

    private String phone;
    private String email;
    private String user_name;



    public User(String phone, String user_name, String email) {
        this.phone = phone;
        this.email = email;
        this.user_name=user_name;

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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
