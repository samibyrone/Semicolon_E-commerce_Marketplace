package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CartItemRemoveResponse {

    @Id
    private String cartItem_id;
    private String message;
}
