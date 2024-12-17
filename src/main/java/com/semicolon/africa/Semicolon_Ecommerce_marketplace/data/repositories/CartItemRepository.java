package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartItemRepository extends MongoRepository<CartItem, String> {

}
