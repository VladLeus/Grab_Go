package com.example.backend.product;

import com.example.backend.product.model.CreateProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final  ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequest createProductRequest){
         return productService.create(createProductRequest);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable("id") Long id
    ) {
        return productService.getById(id);
    }

}
