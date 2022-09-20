package com.example.productApi.product;

import com.example.productApi.brand.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Product product = new Product(1L, "Tomato", "Fruit with a ton of nutrients", 100.00, new Brand("Farmer's market","1b"));
        testEntityManager.persist(product);
    }

    @Test
    void findProductByName() {
        Product found = productRepository.findProductByName("Tomato");
        assertEquals(1L, found.getId());
    }

    @Test
    void findProductByBrand() {

    }
}