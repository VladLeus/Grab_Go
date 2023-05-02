package com.example.backend.product;

import com.example.backend.product.model.CreateProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product create(CreateProductRequest createProductRequest) {
        Product product = Product.builder()
                .price(createProductRequest.price())
                .name(createProductRequest.name())
                .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
