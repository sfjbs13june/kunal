package com.kunal.app.model;


import org.springframework.data.annotation.Id;

public class Hospital {

    String hospitalname;
    String address;
    @Id
    int id;
    public Hospital(){}

    public Hospital(String hospitalname, String address, int id) {
        this.hospitalname = hospitalname;
        this.address = address;
        this.id = id;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
