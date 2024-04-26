package com.example.backend.order;

import com.example.backend.exception.NonExistingIdException;
import com.example.backend.order.model.AddProductRequest;
import com.example.backend.order.model.CreateOrderRequest;
import com.example.backend.product.Product;
import com.example.backend.product.ProductRepository;
import com.example.backend.table.Table;
import com.example.backend.table.TableRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import static java.lang.String.format;

@AllArgsConstructor

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final TableRepository tableRepository;
    private static final Supplier<? extends Throwable> neIDe = () -> new NonExistingIdException("Order with id doesn't exist");

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NonExistingIdException(format("Order with id %s doesn't exist", id)));
    }

    @Override
    public Order create(CreateOrderRequest createOrderRequest) {
        Table orderTable = createOrderRequest.tableId() == null ?
                null :
                tableRepository.findById(createOrderRequest.tableId()).orElse(null);

        Order order = Order.builder()
                .name(createOrderRequest.name())
                .type(createOrderRequest.type())
                .table(orderTable)
                .build();

        orderRepository.save(order);
        if (orderTable != null) {
            orderTable.setOrderId(order.getId());
            tableRepository.save(orderTable);
        }
        return order;
    }

    @SneakyThrows
    @Override
    public Order addProduct(Long id, AddProductRequest addProductRequest) {
        Order order = orderRepository.findById(id).orElseThrow();
        Product product = productRepository.findById(addProductRequest.productId()).orElseThrow(neIDe);
        for (int i = 0; i < addProductRequest.quantity(); i++) {
            order.getProducts().add(product);
        }

        orderRepository.save(order);

        return order;
    }

    @SneakyThrows
    @Override
    public Integer getSortedByTime(Long id) {
        List<Product> allProducts = orderRepository.findById(id)
                .orElseThrow(neIDe)
                .getProducts();
        List<Product> sorted = allProducts.stream()
                .sorted(Comparator.comparing(Product::cookingTime))
                .toList();
        return sorted.get(allProducts.size() - 1).cookingTime();
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
