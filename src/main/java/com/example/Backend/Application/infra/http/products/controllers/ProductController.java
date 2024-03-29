package com.example.Backend.Application.infra.http.products.controllers;

import com.example.Backend.Application.domain.products.data.ProductData;
import com.example.Backend.Application.providers.database.products.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductData productRepository;

    @GetMapping("")
    public ResponseEntity<List<ProductModel>> getProducts() {
        List<ProductModel> products = productRepository.findAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Optional<ProductModel>> getProduct(@PathVariable String slug) {
        Optional<ProductModel> product = productRepository.findProductModelBySlug(slug);

        return ResponseEntity.ok(product);
    }

    @PostMapping("")
    public ResponseEntity<String> createProduct(String title, String slug) {
        ProductModel product = new ProductModel(title, slug);

        productRepository.save(product);

        return ResponseEntity.ok("Sucess!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);

        return ResponseEntity.ok("Sucess!");
    }
}
