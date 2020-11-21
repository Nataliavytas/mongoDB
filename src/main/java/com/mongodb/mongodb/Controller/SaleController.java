package com.mongodb.mongodb.Controller;

import com.mongodb.mongodb.Exceptions.NotEnoughStockException;
import com.mongodb.mongodb.Model.SaleItem;
import com.mongodb.mongodb.Service.ProductService;
import com.mongodb.mongodb.Service.SaleService;
import com.mongodb.mongodb.dao.SaleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<SaleDto> getSales(){
        return saleService.getSales();
    }

    @PostMapping("/")
    public void saveSale(@Valid @RequestBody SaleDto saleDto){
        for(SaleItem p: saleDto.getProducts()){
            int quantity  = p.getQuantity();
            int stock = productService.getProductById(p.getId()).getStock();
            if(quantity > stock){
                throw new NotEnoughStockException("The stock is not enough.");
            }
        }
        saleService.saveSale(saleDto);
    }
}
