package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProductRegisterRequest {

    private String productName;
    private String productDescription;
    private Double productPrice;
    private int productStock;
}
