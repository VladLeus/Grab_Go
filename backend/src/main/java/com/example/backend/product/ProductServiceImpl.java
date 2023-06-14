package com.example.backend.product;

import com.example.backend.exception.NonExistingIdException;
import com.example.backend.product.model.CreateProductRequest;
import com.example.backend.product.types.Dessert;
import com.example.backend.product.types.Drink;
import com.example.backend.product.types.Pizza;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.String.format;

@AllArgsConstructor
@Component
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product create(CreateProductRequest createProductRequest) {
        ProductType productType = createProductRequest.productType();
        Product product = switch (productType) {
            case PIZZA -> Pizza.builder()
                    .name(createProductRequest.name())
                    .price(createProductRequest.price())
                    .category(productType)
                    .build();
            case DESSERT -> Dessert.builder()
                    .name(createProductRequest.name())
                    .price(createProductRequest.price())
                    .category(productType)
                    .build();
            case HOT_DRINK, COLD_DRINK -> Drink.builder()
                    .name(createProductRequest.name())
                    .price(createProductRequest.price())
                    .category(productType)
                    .build();
        };

        productRepository.save(product);

        return product;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NonExistingIdException(format("Product with id %s doesn't exist", id)));
    }

}
