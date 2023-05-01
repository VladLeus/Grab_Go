package com.example.backend.order;

import com.example.backend.order.model.AddProductRequest;
import com.example.backend.order.model.CreateOrderRequest;

public interface OrderService {
    Order getById(Long id);

    Order create(CreateOrderRequest createOrderRequest);

    Order addProduct(Long id, AddProductRequest addProductRequest);
}