package com.kerubinessys.v0.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    private String productName;
    private String productDescription;
    private Double cost;
    private String color;
    private String size;
    private Long stock;
    private String category;
    @ManyToMany
    private List<Sale> saleList;

    public Product(Long idProduct, String productName, String productDescription, Double cost, String color, String size, Long stock, String category, List<Sale> saleList) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productDescription = productDescription;
        this.cost = cost;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.category = category;
        this.saleList = saleList;
    }

    public Product() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", cost=" + cost +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", saleList=" + saleList +
                '}';
    }
}
