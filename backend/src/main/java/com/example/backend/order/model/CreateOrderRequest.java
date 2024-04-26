package com.example.backend.order.model;

import com.example.backend.order.OrderType;
import jakarta.persistence.Table;

public record CreateOrderRequest(
        String name,
        OrderType type,
        Long tableId
) {
}
