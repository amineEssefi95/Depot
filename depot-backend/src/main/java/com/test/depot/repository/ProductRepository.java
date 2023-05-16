package com.test.depot.repository;


import com.test.depot.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

    List<Product> findByCategoryIgnoreCaseAndQuantityGreaterThan(String category, int quantity);

}
