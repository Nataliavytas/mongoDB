package com.mongodb.mongodb.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {

    private String id;

    @NotBlank(message = "Product name is mandatory")
    private String name;

    @NotNull
    private String description;

    @NotNull(message = "Product stock is mandatory")
    private int stock;

    @NotNull(message = "Product price is mandatory")
    private float price;

    public ProductDto(String name, String description, int stock, float price) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    //needed for jackson to deserialize
    public ProductDto(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
