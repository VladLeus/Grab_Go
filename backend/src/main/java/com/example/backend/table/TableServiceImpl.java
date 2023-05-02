package com.example.backend.table;

import com.example.backend.exception.NonExistingIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.String.format;

@RequiredArgsConstructor
@Component
public class TableServiceImpl implements TableService {
    private final TableRepository tableRepository;

    @Override
    public List<Table> getAll() {
        return tableRepository.findAll();
    }

    @Override
    public Table getById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new NonExistingIdException(format("Table with id %s doesn't exist", id)));
    }
}
