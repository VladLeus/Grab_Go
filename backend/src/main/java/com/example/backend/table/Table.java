package com.example.backend.table;

import com.example.backend.order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@jakarta.persistence.Table(schema = "public")
public class Table {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long orderId;
}
