package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
}
