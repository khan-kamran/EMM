package com.example.EMM.entity;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer addressId;
    @Column
    String address;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "employee_ID")
    Employee employee;

    @Column
    String departmentId;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "city_Id")
    City city;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
