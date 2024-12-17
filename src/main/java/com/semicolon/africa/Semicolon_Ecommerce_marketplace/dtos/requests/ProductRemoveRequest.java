package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ProductCategory;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProductRemoveRequest {

    private String ProductId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productStock;
    private ProductCategory productCategory;
}
