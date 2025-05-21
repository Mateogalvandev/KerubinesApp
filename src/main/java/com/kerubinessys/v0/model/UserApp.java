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
    private String name;
    private String surname;
    private String dni;
    private String rol;
    @OneToMany(mappedBy = "userSale")
    private List<Sale> saleList;

    public UserApp(Long idUser, String name, String surname, String dni, String rol, List<Sale> saleList) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", rol='" + rol + '\'' +
                ", saleList=" + saleList +
                '}';
    }
}
