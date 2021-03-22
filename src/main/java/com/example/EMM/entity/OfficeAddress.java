package com.example.EMM.entity;

import javax.persistence.*;

@Entity
public class OfficeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer officeAddressId;
    @Column
    String officeAddress;
    @Column
    String dName;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Integer getOfficeAddressId() {
        return officeAddressId;
    }

    public void setOfficeAddressId(Integer officeAddressId) {
        this.officeAddressId = officeAddressId;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}
