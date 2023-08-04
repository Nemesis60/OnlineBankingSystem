package com.Project.OnlineBankingSystem.Domain.DTO;

import com.Project.OnlineBankingSystem.Common.Rol;
import com.Project.OnlineBankingSystem.Domain.Model.User;

import java.io.Serializable;
import java.time.LocalDate;

public class UserDTO implements Serializable {
    private String lastName;
    private String firstName;
    private String document;
    private LocalDate bornDate;
    private String username;
    private String email;
    private String phoneNumber;
    private Rol rol;
    private AddressDTO addressDTO;

    public UserDTO(String lastName, String firstName, String document, LocalDate bornDate, String username, String email,
                   String phoneNumber, Rol rol, AddressDTO addressDTO
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.document = document;
        this.bornDate = bornDate;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rol = rol;
        this.addressDTO = addressDTO;
    }

    public UserDTO() {

    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public LocalDate getBornDate() {
        return bornDate;
    }
    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDocument(user.getDocument());
        userDTO.setBornDate(user.getBornDate());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setRol(user.getRol());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        if (user.getAddress() != null) {
            userDTO.setAddressDTO(AddressDTO.fromEntity(user.getAddress()));
        }
        return userDTO;
    }
}
