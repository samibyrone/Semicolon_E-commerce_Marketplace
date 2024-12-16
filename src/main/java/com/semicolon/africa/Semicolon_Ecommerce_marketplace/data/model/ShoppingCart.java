package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ShoppingCart {

    @Id
    private int cart_id;
    private int user_id;
    private double totalPrice;
}
