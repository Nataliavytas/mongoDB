package com.mongodb.mongodb.Service;

import com.mongodb.mongodb.Exceptions.ProductNotFoundException;
import com.mongodb.mongodb.Model.Product;
import com.mongodb.mongodb.Repository.ProductRepository;
import com.mongodb.mongodb.dao.ProductDto;
import com.mongodb.mongodb.utils.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> getAll(){
        return ProductConverter.convert(this.productRepository.findAll());
    }

    public ProductDto getProductById(String id) throws ProductNotFoundException{
        Product product = productRepository.findById(id).get();
        if(product != null){
            return ProductConverter.convert(product);
        }
        throw new ProductNotFoundException("Producto no encontrado");
    }

    public ProductDto saveProduct(ProductDto product){
        Product newProduct = ProductConverter.convert(product);
        Product productSaved = productRepository.save(newProduct);
        return ProductConverter.convert(productSaved);
    }

    public ProductDto updateProduct(ProductDto newProduct, String id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).get();

        if(product == null){
            throw new ProductNotFoundException("Producto no encontrado");
        }
        product.setStock(newProduct.getStock());
        product.setDescription(newProduct.getDescription());
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        return ProductConverter.convert(productRepository.save(product));
    }


    public void deleteProduct(String id) {
        Product product = productRepository.findById(id).get();

        if(product == null) {
            throw new ProductNotFoundException("Producto no encontrado");
        }
        productRepository.deleteById(id);
    }
}
