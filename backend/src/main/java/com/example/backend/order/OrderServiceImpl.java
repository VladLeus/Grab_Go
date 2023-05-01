package com.example.backend.order;

import com.example.backend.exception.NonExistingIdException;
import com.example.backend.order.model.AddProductRequest;
import com.example.backend.order.model.CreateOrderRequest;
import com.example.backend.product.Product;
import com.example.backend.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@AllArgsConstructor

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NonExistingIdException(format("Order with id %s doesn't exist", id)));
    }

    @Override
    public Order create(CreateOrderRequest createOrderRequest) {
        Order order = Order.builder()
                .name(createOrderRequest.name())
                .build();
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addProduct(Long id, AddProductRequest addProductRequest) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NonExistingIdException(format("Order with id %s doesn't exist", id)));
        Product product = productRepository.findById(addProductRequest.productId()).orElseThrow(() -> new NonExistingIdException(format("Product with id %s doesn't exist", addProductRequest.productId())));
        for(int i = 0; i < addProductRequest.quantity(); i++) {
            order.getProducts().add(product);
        }

        orderRepository.save(order);

        return order;
    }


}
