package com.mongodb.mongodb.Service;

import com.mongodb.mongodb.Model.Product;
import com.mongodb.mongodb.Model.SaleItem;
import com.mongodb.mongodb.Model.Sale;
import com.mongodb.mongodb.Repository.ProductRepository;
import com.mongodb.mongodb.Repository.SaleRepository;
import com.mongodb.mongodb.dao.SaleDto;
import com.mongodb.mongodb.utils.SaleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ProductRepository productRepository;

    public List<SaleDto> getSales() {
        return SaleConverter.convert(saleRepository.findAll());
    }

    public void saveSale(SaleDto saleDto) {
        Sale sale = SaleConverter.convert(saleDto);

        for(SaleItem p: sale.getProducts()){
            Product product = productRepository.findById(p.getId()).get();
            int quantity  = p.getQuantity();
            int stock = product.getStock();
            product.setStock(stock - quantity);
        }

        saleRepository.save(sale);

    }
}
