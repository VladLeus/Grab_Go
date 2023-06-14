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
@Table(name="PRODUCT")
public abstract class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private ProductType category;

    public abstract Integer cookingTime();
}
