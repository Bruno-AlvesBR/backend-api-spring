package com.example.Backend.Application.domain.products.data;

import com.example.Backend.Application.providers.database.products.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductData extends MongoRepository<ProductModel, String> {
    @Query("{slug:  '?0'}")
    Optional<ProductModel> findProductModelBySlug(String slug);
}
