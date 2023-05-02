package com.example.backend.order;

import com.example.backend.product.Product;
import jakarta.persistence.*;
import lombok.*;
import com.example.backend.table.Table;
import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@jakarta.persistence.Table(schema = "public")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            foreignKey = @ForeignKey(
                    name = "fk_order_on_product"
            )
    )
    private List<Product> products;

    @OneToOne
    @JoinTable(
            name = "order_table",
            joinColumns = @JoinColumn(name = "order_id")
    )
    private Table table;

    @Enumerated(EnumType.STRING)
    private OrderType type;
}
