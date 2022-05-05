package com.example.productApi.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product k70 = new Product(
                    "K70 RGB PRO Mechanical Gaming Keyboard",
                    "High end gaming keyboard",
                    "Corsair",
                    192,
                    169.99
            );
            Product s22Ultra = new Product(
                    "S22 Ultra 512 GB Unlocked",
                    "6.8-inch Dynamic AMOLED display with 120Hz refresh rate, Snapdragon 8 Gen 1 processor, 5000mAh battery, 12gigs of RAM, and 1TB of storage",
                    "Samsung",
                    5100,
                    1199.99
            );
            productRepository.saveAll(
                    List.of(k70,s22Ultra)
            );
        };
    }
}
