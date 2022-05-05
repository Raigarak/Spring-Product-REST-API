package com.example.productApi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public Product findProductByID(Long id) {
        return productRepository.findById(id).get();
    }

    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void addProducts(List<Product> products) {
        this.productRepository.saveAll(products);
    }

    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    public List<Product> findProductByBrand(String brand) {
        return productRepository.findProductByBrand(brand);
    }

    public void updateProduct(Long id, Product product) {
        Product oldProduct = productRepository.findById(id).get();
        if(product.getName() != null && !product.getName().isEmpty()) {
            oldProduct.setName(product.getName());
        }
        if(product.getDescription()!= null && !product.getDescription().isEmpty()) {
            oldProduct.setDescription(product.getDescription());
        }
        if(product.getBrand() != null && !product.getBrand().isEmpty()) {
            oldProduct.setBrand(product.getBrand());
        }
        if(product.getQuantity() >= 0) {
            oldProduct.setQuantity(product.getQuantity());
        }
        if(product.getPrice() >= 0) {
            oldProduct.setPrice(product.getPrice());
        }
        productRepository.save(oldProduct);
    }
}
