package com.mongodb.mongodb.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection="sales")
public class Sale {
    @Id
    private String id;
    private List<SaleItem> products;
    private Float totalPrice;
    private String deliverAdress;

    public Sale(List<SaleItem> products, Float totalPrice, String deliverAdress) {
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
