package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String email;
    private String password;
}
