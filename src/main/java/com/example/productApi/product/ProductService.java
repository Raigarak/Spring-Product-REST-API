package com.example.productApi.product;

import com.example.productApi.brand.Brand;
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

    public Product findProductByBrand(Brand brand) {
        return productRepository.findProductByBrand(brand);
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

    public void updateProduct(Long id, Product newProduct) {
        productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setBrand(newProduct.getBrand());
                    return productRepository.save(product);
                })
                .orElseGet(() -> productRepository.save(newProduct)
                );
    }
}
