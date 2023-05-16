package com.test.depot.repository;

import com.test.depot.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@SpringJUnitConfig
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void init() {
        Product product1 = new Product(null, "c1", "p1", 3);
        productRepository.save(product1);
        Product product2 = new Product(null, "c1", "p2", 0);
        productRepository.save(product2);
        Product product3 = new Product(null, "c2", "p3", 5);
        productRepository.save(product3);
    }

    @Test
    void testSave() {

        Product product = new Product(null, "c3", "p5", 10);
        productRepository.save(product);

        List<Product> products = productRepository.findAll();

        assertEquals(4, products.size());
    }

    @Test
    void testFindAll() {

        List<Product> products = productRepository.findAll();

        assertEquals(3, products.size());
    }

    @Test
    void testFindByCategoryIgnoreCaseAndQuantityGreaterThan() {

        List<Product> products = productRepository.findByCategoryIgnoreCaseAndQuantityGreaterThan("c1", 0);

        assertEquals(1, products.size());
    }

    @AfterEach
    public void tearDown() {
        mongoTemplate.getCollectionNames().forEach(collectionName -> mongoTemplate.dropCollection(collectionName));
    }
}
