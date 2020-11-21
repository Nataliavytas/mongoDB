package com.mongodb.mongodb.utils;

import com.mongodb.mongodb.Model.Product;
import com.mongodb.mongodb.dao.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter {

    public static List<ProductDto> convert(List<Product> products){
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product p: products){
            ProductDto productDto = new ProductDto(p.getName(), p.getDescription(), p.getStock(), p.getPrice());
            productDto.setId(p.getId());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static ProductDto convert(Product product){
        ProductDto productDto = new ProductDto(product.getName(), product.getDescription(), product.getStock(), product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }

    public static Product convert(ProductDto productDto){
        Product product = new Product(productDto.getName(), productDto.getDescription(), productDto.getStock(), productDto.getPrice());
        return product;
    }

}
