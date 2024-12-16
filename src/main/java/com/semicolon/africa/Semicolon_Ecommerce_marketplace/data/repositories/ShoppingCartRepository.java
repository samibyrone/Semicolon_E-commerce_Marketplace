package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
