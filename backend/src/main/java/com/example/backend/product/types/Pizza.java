package com.example.backend.product.types;

import com.example.backend.product.Product;
import com.example.backend.product.ProductType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("PIZZA")
public class Pizza  extends Product {
    public Pizza(Long id, String name, Double price, ProductType category) {
        super(id, name, price, category);
    }

    @Override
    public Integer cookingTime() {
        return 40;
    }
}
