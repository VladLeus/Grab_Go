package com.example.backend;

import com.example.backend.order.OrderRepository;
import com.example.backend.product.Product;
import com.example.backend.product.ProductRepository;
import com.example.backend.product.ProductType;
import com.example.backend.product.types.Dessert;
import com.example.backend.product.types.Drink;
import com.example.backend.product.types.Pizza;
import com.example.backend.table.Table;
import com.example.backend.table.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        TableRepository tableRepository = context.getBean(TableRepository.class);

        //Clean up repositories
        orderRepository.deleteAll();
        productRepository.deleteAll();
        tableRepository.deleteAll();

        //Add products to repository
        //to extend just add new products at the end of List.of()
        List<Product> products = List.of(
                Pizza.builder()
                        .name("4 Cheese")
                        .category(ProductType.PIZZA)
                        .price(15.65)
                        .build(),
                Pizza.builder()
                        .name("Pepperoni")
                        .category(ProductType.PIZZA)
                        .price(12.89)
                        .build(),
                Pizza.builder()
                        .name("Margarita")
                        .category(ProductType.PIZZA)
                        .price(13.45)
                        .build(),
                Pizza.builder()
                        .name("Hawaii")
                        .category(ProductType.PIZZA)
                        .price(11.25)
                        .build(),
                Pizza.builder()
                        .name("Meat")
                        .category(ProductType.PIZZA)
                        .price(14.49)
                        .build(),
                Dessert.builder()
                        .name("Cheese cake")
                        .category(ProductType.DESSERT)
                        .price(8.99)
                        .build(),
                Dessert.builder()
                        .name("Hot chocolate")
                        .category(ProductType.DESSERT)
                        .price(5.25)
                        .build(),
                Dessert.builder()
                        .name("Cinnabon")
                        .category(ProductType.DESSERT)
                        .price(2.49)
                        .build(),
                Dessert.builder()
                        .name("Brownies")
                        .category(ProductType.DESSERT)
                        .price(1.99)
                        .build(),
                Drink.builder()
                        .name("Americano")
                        .category(ProductType.HOT_DRINK)
                        .price(2.35)
                        .build(),
                Drink.builder()
                        .name("Espresso")
                        .category(ProductType.HOT_DRINK)
                        .price(1.85)
                        .build(),
                Drink.builder()
                        .name("Late")
                        .category(ProductType.HOT_DRINK)
                        .price(3.15)
                        .build(),
                Drink.builder()
                        .name("Tea")
                        .category(ProductType.HOT_DRINK)
                        .price(1.25)
                        .build(),
                Drink.builder()
                        .name("MilkShake")
                        .category(ProductType.COLD_DRINK)
                        .price(5.34)
                        .build(),
                Drink.builder()
                        .name("Lemonade")
                        .category(ProductType.COLD_DRINK)
                        .price(2.25)
                        .build(),
                Drink.builder()
                        .name("Mojito")
                        .category(ProductType.COLD_DRINK)
                        .price(4.99)
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

    @Bean
    public CorsFilter corsFilter() {
        final String acai = "Access-Control-Allow-Origin";
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:3000", "http://localhost:5173"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", acai, "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                acai, acai, "Access-Control-Allow-Credentials", "File-Name"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
