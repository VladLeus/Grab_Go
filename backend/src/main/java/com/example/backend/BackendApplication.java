package com.example.backend;

import com.example.backend.product.Product;
import com.example.backend.product.ProductRepository;
import com.example.backend.product.ProductType;
import com.example.backend.table.Table;
import com.example.backend.table.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        TableRepository tableRepository = context.getBean(TableRepository.class);

        //Clean up repositories
        productRepository.deleteAll();
        tableRepository.deleteAll();

        //Add products to repository
        //to extend just add new products at the end of List.of()
        List<Product> products = List.of(
                Product.builder()
                        .name("4 Сири")
                        .type(ProductType.PIZZA)
                        .price(100.0)
                        .build(),
                Product.builder()
                        .name("Пиво")
                        .type(ProductType.LUNCH)
                        .price(50.0)
                        .build(),
                Product.builder()
                        .name("Кава")
                        .type(ProductType.HOT_DRINK)
                        .price(60.0)
                        .build(),
                Product.builder()
                        .name("Твоя мама")
                        .type(ProductType.DESSERT)
                        .price(0.0)
                        .build());
        productRepository.saveAll(products);
        //Add tables to repository
        //to extend just add new products at the end of List.of()
        List<Table> tables = List.of(
                Table.builder()
                        .name("Table 1")
                        .build(),
                Table.builder()
                        .name("Table 2")
                        .build(),
                Table.builder()
                        .name("Table 3")
                        .build()
        );
        tableRepository.saveAll(tables);
    }
}
