package com.example.backend.product.model;

import com.example.backend.product.ProductType;

public record CreateProductRequest (
        String name,
        Double price,
        ProductType productType
) {
}
