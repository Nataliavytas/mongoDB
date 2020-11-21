package com.mongodb.mongodb.Repository;

import com.mongodb.mongodb.Model.Product;
import com.mongodb.mongodb.Model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository  extends MongoRepository<Sale, String> {
}
