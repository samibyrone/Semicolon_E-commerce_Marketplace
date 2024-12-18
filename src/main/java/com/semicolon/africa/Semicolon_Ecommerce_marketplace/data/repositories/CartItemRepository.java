package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartItemRepository extends MongoRepository<CartItem, String> {

    Optional<CartItem> findById(String cartItem_id);
}
