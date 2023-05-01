package com.example.backend.order;

import com.example.backend.order.model.AddProductRequest;
import com.example.backend.order.model.CreateOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
