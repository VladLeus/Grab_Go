package com.example.backend.product;

import com.example.backend.product.model.CreateProductRequest;

import java.util.List;

public interface ProductService {
    Product create(CreateProductRequest product);

    List<Product> getAll();

    Product getById(Long id);
}
