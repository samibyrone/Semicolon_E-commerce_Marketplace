package com.semicolon.africa.Semicolon_Ecommerce_marketplace.controller;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.CartItemRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.CartItemRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public ResponseEntity<CartItemRegisterResponse>
}
