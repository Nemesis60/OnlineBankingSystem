package com.Project.OnlineBankingSystem.Domain.Model;

import jakarta.persistence.*;

@Embeddable
public class Address {
    // ATTRIBUTES
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    // CONSTRUCTOR
    public Address() {}
    public Address(
            String city, String street, String zipCode
    ) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    // GETTER and SETTER city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    // GETTER and SETTER direction
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    // GETTER and SETTER zipCode
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
