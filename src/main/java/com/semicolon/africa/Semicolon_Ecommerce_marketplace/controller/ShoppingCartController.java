package com.semicolon.africa.Semicolon_Ecommerce_marketplace.controller;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping()
    public ResponseEntity<ShoppingCartRegisterRequest>
}
