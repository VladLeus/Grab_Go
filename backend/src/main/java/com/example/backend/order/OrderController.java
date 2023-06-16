package com.example.backend.order;

import com.example.backend.order.model.AddProductRequest;
import com.example.backend.order.model.CreateOrderRequest;
import com.example.backend.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;



    @GetMapping("/{id}")
    public Order getById(
            @PathVariable("id") Long id
    ) {
        return orderService.getById(id);
    }

    @PostMapping
    public Order create(
            @RequestBody CreateOrderRequest createOrderRequest
    ) {
        return orderService.create(createOrderRequest);
    }

    @PostMapping("/{id}/products")
    public Order addProduct(
            @PathVariable("id") Long id,
            @RequestBody AddProductRequest addProductRequest
    ) {
        return orderService.addProduct(id, addProductRequest);
    }

    @GetMapping("/{id}/products/cooking")
    public Integer getSortedByTimeProducts(
            @PathVariable("id") Long id
    ) {
        return orderService.getSortedByTime(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
    }
}
