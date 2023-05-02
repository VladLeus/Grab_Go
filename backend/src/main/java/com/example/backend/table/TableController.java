package com.example.backend.table;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
