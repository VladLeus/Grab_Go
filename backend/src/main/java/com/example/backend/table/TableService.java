package com.example.backend.table;

import java.util.List;

public interface TableService {
    List<Table> getAll();

    Table getById(Long id);

    Table updateOrderId(Long id, Long orderId);
}
