package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CartItem {

    @Id
    private int cartItem_id;
    private int product_id;
    private int quantity;
    private double price;
}
