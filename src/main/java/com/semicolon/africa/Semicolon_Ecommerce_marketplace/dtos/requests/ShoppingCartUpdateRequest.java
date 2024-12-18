package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.CartItem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class ShoppingCartUpdateRequest {

    @Id
    private String shoppingCart_id;
    private List<CartItem> items = new ArrayList<>();
    private double totalPrice;
}
