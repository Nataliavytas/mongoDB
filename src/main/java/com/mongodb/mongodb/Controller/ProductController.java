package com.mongodb.mongodb.Controller;

import com.mongodb.mongodb.Exceptions.ProductNotFoundException;
import com.mongodb.mongodb.Service.ProductService;
import com.mongodb.mongodb.dao.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable String id ) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping("/")
    public ProductDto saveProduct(@Valid @RequestBody ProductDto product){
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@Valid @RequestBody ProductDto product, @PathVariable String id) throws ProductNotFoundException {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) throws ProductNotFoundException{
        productService.deleteProduct(id);
    }

}
