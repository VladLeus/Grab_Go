package com.example.backend.product.model;

public record CreateProductRequest (
        String name,
        Double price
) {

}
