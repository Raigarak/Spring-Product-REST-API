package com.example.productApi.product;

import com.example.productApi.brand.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Get all products in the database")
    void findProducts() {
        // when
        productService.findProducts();
        // then
        verify(productRepository).findAll();
    }

    @Test
    @DisplayName("Get product based on valid product name")
    void findProductByName() {
        Product product = new Product(1L, "Tomato", "Fruit with a ton of nutrients", 100.00, new Brand("Farmer's market","1b"));
        Mockito.when(productRepository.findProductByName("Tomato"))
                .thenReturn(product);

        // given
        String productName = "Tomato";
        // when
        Product found = productService.findProductByName(productName);
        // then
        assertEquals(productName, found.getName());
    }

    @Test
    @DisplayName("Get product based on valid product name")
    void findProductByBrand() {
        Product product = new Product(1L, "Tomato", "Fruit with a ton of nutrients", 100.00, new Brand("Farmer's market","1b"));
        Mockito.when(productRepository.findProductByBrand(product.getBrand()))
                .thenReturn(product);

        // given
        Brand brand = new Brand("Farmer's market","1b");
        // when
        Product found = productService.findProductByBrand(brand);
        // then
        assertEquals(brand, found.getBrand());
    }

    @Test
    void findProductByID() {
        Product productWithId = new Product(1L, "Tomato", "Fruit with a ton of nutrients", 100.00, new Brand("Farmer's market","1b"));
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(productWithId));

        // given
        Long productId = 1L;
        // when
        Product product = productService.findProductByID(productId);
        // then
        assertEquals(productId, product.getId());
    }

    @Test
    @DisplayName("Check if adding product to database is working")
    void addProduct() {
        // given
        Product product = new Product(10L,"Cookies and Cream cake pop", "crunchy and creamy", 5.00, new Brand("Mcdonalds", "5t"));
        // when
        productService.addProduct(product);
        // then
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);

        verify(productRepository).save(productArgumentCaptor.capture());

        Product capturedProduct = productArgumentCaptor.getValue();
        assertEquals(product, capturedProduct);
    }

    @Test
    @DisplayName("Check if adding list of products is working")
    void addProducts() {
    }

    @Test
    @DisplayName("Check if deleting product is working")
    void deleteProduct() {
        Product product = new Product(1L, "Tomato", "Fruit with a ton of nutrients", 100.00, new Brand("Farmer's market","1b"));

        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        productService.deleteProduct(product.getId());

        verify(productRepository).deleteById(product.getId());

    }

    @Test
    @DisplayName("Check If updating product is working")
    void updateProduct() {

        Product product = new Product(1L, "Tomato", "Fruit with a ton of nutrients", 100.00, new Brand("Farmer's market","1b"));
        Product updatedProduct = new Product(2L, "Potato", "Fruit with a ton of nutrients", 500.00, new Brand("Farmer's market","1b"));

        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        productService.updateProduct(product.getId(), updatedProduct);

        verify(productRepository).save(updatedProduct);
        verify(productRepository).findById(product.getId());
    }
}