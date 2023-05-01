package com.example.backend.product;

import com.example.backend.product.model.CreateProductRequest;

public interface ProductService {
    Product create(CreateProductRequest product);
    List<Product> getAll();
    Product getById(Long id);
}
