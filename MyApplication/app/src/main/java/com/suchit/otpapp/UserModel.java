package com.suchit.otpapp;

public class UserModel {
    String name;
    int mobile_no;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(int mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
