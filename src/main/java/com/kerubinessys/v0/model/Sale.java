package com.kerubinessys.v0.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSale;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "type_sale")
    private String typeSale;
    @ManyToMany
    @JoinTable(
            name = "sale_product",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;
    @ManyToOne
    private UserApp userSale;
    private Double totalCost;

    public Sale(Long idSale, LocalDate date, String typeSale, List<Product> productList, UserApp userSale, Double totalCost) {
        this.idSale = idSale;
        this.date = date;
        this.typeSale = typeSale;
        this.productList = productList;
        this.userSale = userSale;
        this.totalCost = totalCost;
    }

    public Sale() {
    }

    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTypeSale() {
        return typeSale;
    }

    public void setTypeSale(String typeSale) {
        this.typeSale = typeSale;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public UserApp getUserSale() {
        return userSale;
    }

    public void setUserSale(UserApp userSale) {
        this.userSale = userSale;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", date=" + date +
                ", typeSale='" + typeSale + '\'' +
                ", productList=" + productList +
                ", userSale=" + userSale +
                ", totalCost=" + totalCost +
                '}';
    }
}
