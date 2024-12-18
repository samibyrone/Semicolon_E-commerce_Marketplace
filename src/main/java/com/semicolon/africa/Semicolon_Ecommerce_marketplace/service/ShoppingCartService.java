package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ShoppingCart;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartRemoveRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartUpdateRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ShoppingCartRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ShoppingCartRemoveResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ShoppingCartUpdateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingCartService {

    ShoppingCartRegisterResponse addItemToCart(ShoppingCartRegisterRequest shoppingCartRegisterRequest);

    ShoppingCartRemoveResponse removeItemFromCart(ShoppingCartRemoveRequest shoppingCartRemoveRequest);

    ShoppingCartRemoveResponse removeItemFromCart(String cartItem_id, String product_id);

    ShoppingCartUpdateResponse updateItemInCart(ShoppingCartUpdateRequest shoppingCartUpdateRequest);

    List<ShoppingCart> getAllShoppingCartItems();
}
