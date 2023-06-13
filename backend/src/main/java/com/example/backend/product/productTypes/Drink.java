package com.example.backend.product.productTypes;

import com.example.backend.product.Product;
import com.example.backend.product.ProductType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("HOT_DRINK")
public class Drink  extends Product {

    public Drink(Long id, String name, Double price, ProductType category) {
        super(id, name, price, category);
    }

    @Override
    protected Integer getCookingTime(Product product) {
        return product.getCategory() == ProductType.HOT_DRINK ? 10 : 12;
    }
}
