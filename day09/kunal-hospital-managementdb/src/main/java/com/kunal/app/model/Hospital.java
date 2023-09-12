package com.kunal.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Hospital {

    @Column(name = "hospitalname")
    String hospitalname;

    @Column(name = "address")
    String address;
    @Id
    @GeneratedValue
    @Column(name = "id")
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
