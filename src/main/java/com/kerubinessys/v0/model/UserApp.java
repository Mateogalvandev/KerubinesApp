package com.kerubinessys.v0.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    private String username;
    private String surname;
    private String password;
    private String dni;
    private String rol;
    @OneToMany(mappedBy = "userSale")
    private List<Sale> saleList;

    public UserApp(Long idUser, String username, String surname, String password, String dni, String rol, List<Sale> saleList) {
        this.idUser = idUser;
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.dni = dni;
        this.rol = rol;
        this.saleList = saleList;
    }

    public UserApp() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    @Override
    public String toString() {
        return "UserApp{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", rol='" + rol + '\'' +
                ", saleList=" + saleList +
                '}';
    }
}
