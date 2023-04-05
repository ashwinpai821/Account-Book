package com.example.accountbook1;

public class UserHelperClass {
    String name, phoneNo, deadline;
    boolean status;
    float amount;

    public UserHelperClass() {
    }
    public UserHelperClass(String name, String phoneNo, String deadline,float amount, boolean status) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.deadline = deadline;
        this.amount = amount;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount= amount;
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}