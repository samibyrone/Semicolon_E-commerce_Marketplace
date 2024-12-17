package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class CartItem {

    @Id
    private String cartItem_id;
    private List<Product> products = new ArrayList<>();
    private int quantityOfProducts;
    private double price;
    private ProductCategory productcategory;
}
