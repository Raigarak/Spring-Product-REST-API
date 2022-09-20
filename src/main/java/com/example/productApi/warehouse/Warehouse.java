package com.example.productApi.warehouse;

import com.example.productApi.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Warehouse {
    @Id
    @SequenceGenerator(
            name = "warehouse_sequence",
            sequenceName = "warehouse_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "warehouse_sequence"
    )
    private Long id;
    private Long quantity;

    // Warehouse is the entity that own the relationship
    @ManyToMany(mappedBy = "warehouses", fetch = FetchType.LAZY)
    private Set<Product> products;
}
