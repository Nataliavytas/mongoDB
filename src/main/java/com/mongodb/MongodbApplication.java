package com.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.mongodb.Model.Product;
import com.mongodb.mongodb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {
    private ProductRepository productRepository;


    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/basededatos");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "basededatos");
    }

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product lays = new Product(
                "Lays",
                "Best Chips in the world",
                10,
                30.50F
        );

        Product cardbury = new Product(
                "Cardbury",
                "Best chocolate",
                5,
                90.50F
        );

        Product oreo = new Product(
                "Oreo",
                "Best cookies",
                20,
                60.30F
        );

        //drop all products
        this.productRepository.deleteAll();

        //add producst to db
        List<Product> products = Arrays.asList(lays, cardbury, oreo);
        this.productRepository.saveAll(products);
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
