package com.example.backend.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance
@DiscriminatorColumn(name="PRODUCT_TYPE")
@Table(name="PRODUCTS")
public abstract class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private ProductType category;

    protected abstract Integer getCookingTime(Product product);
}
