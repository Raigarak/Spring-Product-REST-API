package com.example.productApi.product;

import com.example.productApi.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT s FROM Product s WHERE s.name = ?1")
    Product findProductByName(String name);

    @Query("SELECT s from Product s WHERE s.brand = ?1")
    Product findProductByBrand(Brand brand);
}