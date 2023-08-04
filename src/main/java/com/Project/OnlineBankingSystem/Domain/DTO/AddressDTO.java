package com.Project.OnlineBankingSystem.Domain.DTO;

import com.Project.OnlineBankingSystem.Domain.Model.Address;

public class AddressDTO {
    private String city;
    private String street;
    private String zipCode;

    public AddressDTO() {}
    public AddressDTO(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public static AddressDTO fromEntity(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setZipCode(address.getZipCode());

        return addressDTO;
    }
}
