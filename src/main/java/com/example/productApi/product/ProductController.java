package com.example.productApi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("api/v1/products")
    public List<Product> getProducts() {
        return productService.findProducts();
    }

    @GetMapping("api/v1/product/id/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.findProductByID(id);
    }

    @GetMapping("api/v1/product/name/{name}")
    public Product getProductByName(@PathVariable("name") String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("api/v1/product/brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable("brand") String brand) {
        return productService.findProductByBrand(brand);
    }

    @PostMapping("api/v1/addProduct")
    public void addProduct(@RequestBody Product product) {
         productService.addProduct(product);
    }

    @PostMapping("api/v1/addProducts")
    public void addProducts(@RequestBody List<Product> products) {
        productService.addProducts(products);
    }

    @PutMapping("api/v1/product/update/{id}")
    public void updateProduct(@PathVariable("id") Long id,
                                 @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("api/v1/product/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
