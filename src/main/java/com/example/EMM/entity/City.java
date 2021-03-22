package com.example.EMM.entity;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_Id")
    Integer cityId;
    @Column(name = "name")
    String name;

/*    @OneToOne(mappedBy="city")
    Address address;*/

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
