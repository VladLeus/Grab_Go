package com.example.backend.order;

import com.example.backend.order.model.AddProductRequest;
import com.example.backend.order.model.CreateOrderRequest;
import com.example.backend.product.Product;

import java.util.List;

public interface OrderService {
    Order getById(Long id);

    Order create(CreateOrderRequest createOrderRequest);

    Order addProduct(Long id, AddProductRequest addProductRequest);

    Integer getSortedByTime(Long id);

    void deleteOrderById(Long id);
}