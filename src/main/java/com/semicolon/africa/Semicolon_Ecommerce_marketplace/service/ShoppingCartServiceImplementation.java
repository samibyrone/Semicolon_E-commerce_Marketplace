package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ShoppingCart;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.CartItemRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.ShoppingCartRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ShoppingCartRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.ShoppingCartIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImplementation {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public ShoppingCartRegisterResponse AddItemToCart(String shoppingCart_id, ShoppingCartRegisterRequest shoppingCartRegisterRequest) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCart_id)
                .orElseThrow( () -> new ShoppingCartIdNotFoundException("Shopping Cart Not Found"));
    }
}
