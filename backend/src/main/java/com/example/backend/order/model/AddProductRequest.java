package com.example.backend.order.model;

public record AddProductRequest(
        Long productId,
        Integer quantity
) {
}
