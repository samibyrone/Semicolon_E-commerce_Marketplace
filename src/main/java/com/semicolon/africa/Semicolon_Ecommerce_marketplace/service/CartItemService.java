package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CartItemService {


    Optional<CartItem> findItemById(String cartItemId);
}
