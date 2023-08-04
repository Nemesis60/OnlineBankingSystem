package com.Project.OnlineBankingSystem.Domain.DTO;

import com.Project.OnlineBankingSystem.Common.Rol;

import java.time.LocalDate;

public class UserPatchDTO {
    private String lastName;
    private String firstName;
    private LocalDate bornDate;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Rol rol;
    private AddressPatchDTO addressPatchDTO;

    public UserPatchDTO(String lastName, String firstName, LocalDate bornDate, String username, String email,
                        String password, String phoneNumber, Rol rol, AddressPatchDTO addressPatchDTO) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.bornDate = bornDate;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.rol = rol;
        this.addressPatchDTO = addressPatchDTO;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public AddressPatchDTO getAddressPatchDTO() {
        return this.addressPatchDTO;
    }
    public void setAddressPatchDTO(AddressPatchDTO addressPatchDTO) {
        this.addressPatchDTO = addressPatchDTO;
    }
}
