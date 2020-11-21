package com.mongodb.mongodb.dao;

import com.mongodb.mongodb.Model.SaleItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class SaleDto {

    @NotEmpty(message = "At least one product is mandatory")
    private List<SaleItem> products;

    @NotNull(message = "Sale totalPrice is mandatory")
    private Float totalPrice;

    @NotBlank(message = "Sale deliverAdress is mandatory")
    private String deliverAdress;

    public SaleDto(List<SaleItem> products, Float totalPrice, String deliverAdress) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.deliverAdress = deliverAdress;
    }

    public List<SaleItem> getProducts() {
        return products;
    }

    public void setProducts(List<SaleItem> products) {
        this.products = products;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliverAdress() {
        return deliverAdress;
    }

    public void setDeliverAdress(String deliverAdress) {
        this.deliverAdress = deliverAdress;
    }
}
