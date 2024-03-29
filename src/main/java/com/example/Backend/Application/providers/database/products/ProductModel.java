package com.example.Backend.Application.providers.database.products;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product")
public class ProductModel {
    @Id
    private String id;

    private String title;
    @Indexed(unique = true)
    private String slug;

    public ProductModel(String title, String slug) {
        this.title = title;
        this.slug = slug;
    }
}
