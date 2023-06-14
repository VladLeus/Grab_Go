package com.example.backend.product.types;

import com.example.backend.product.Product;
import com.example.backend.product.ProductType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.example.backend.product.ProductType.HOT_DRINK;

@Entity
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("HOT_DRINK")
public class Drink extends Product {

    public Drink(Long id, String name, Double price, ProductType category) {
        super(id, name, price, category);
    }

    @Override
    public Integer cookingTime() {
        return getCategory() == HOT_DRINK ? 10 : 12;
    }
}
