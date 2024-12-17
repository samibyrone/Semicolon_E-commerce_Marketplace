package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class ShoppingCart {

    @Id
    private String shoppingCart_id;
    private List<CartItem> items = new ArrayList<>();
    private double totalPrice;
}
