package com.example.accountbook1;

public class UserHelperClass2 {
    String name, username, email, phoneNo, password,store_name;

    public UserHelperClass2() {
    }
    public UserHelperClass2(String name, String email, String phoneNo, String password,String store_name) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.store_name = store_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getStore_name() {
        return name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
}