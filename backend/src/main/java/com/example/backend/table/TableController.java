package com.example.backend.table;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tables")
public class TableController {
    private final TableService tableService;

    @GetMapping
    public List<Table> getAllTables() {
        return tableService.getAll();
    }

    @GetMapping("/{id}")
    public Table getTableById(
            @PathVariable("id") Long id
    ) {
        return tableService.getById(id);
    }

    @PutMapping("/{id}")
    public Table updateTableOrder(
            @PathVariable("id") Long id
    ) {
        return tableService.updateOrderId(id, null);
    }
}
