package com.mongodb.mongodb.utils;


import com.mongodb.mongodb.Model.Sale;
import com.mongodb.mongodb.dao.SaleDto;

import java.util.ArrayList;
import java.util.List;

public class SaleConverter {

    public static List<SaleDto> convert(List<Sale> sales){
        List<SaleDto> salesDtos = new ArrayList<>();
        for(Sale s: sales){
            salesDtos.add(new SaleDto(s.getProducts(), s.getTotalPrice(), s.getDeliverAdress()));
        }
        return salesDtos;
    }

    public static Sale convert(SaleDto saleDto) {
        Sale sale = new Sale(saleDto.getProducts(), saleDto.getTotalPrice(), saleDto.getDeliverAdress());
        return sale;
    }
}
