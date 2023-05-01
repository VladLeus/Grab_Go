package com.example.backend.product;

import com.example.backend.product.model.CreateProductRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
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

    @Override
    public Product getById(Long id) {
        return productRepository.findById()
                .orElseThrow(() -> new NonExistingIdException("Product with given id doesn't exist"));
    }

}
