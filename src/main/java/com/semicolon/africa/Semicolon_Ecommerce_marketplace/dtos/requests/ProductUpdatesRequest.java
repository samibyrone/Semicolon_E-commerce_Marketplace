package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ProductCategory;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProductUpdatesRequest {

    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private int productStock;
    private double productPrice;
    private ProductCategory productCategory;
}
