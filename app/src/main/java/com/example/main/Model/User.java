package com.example.main.Model;

public class User {
    private String Name;
    private String Password;

    public User(){

    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(String name, String password){
        Name = name;
        Password= password;

    }

}
