package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses;

import lombok.Data;

@Data
public class UserLoginResponse {

    private String message;
    private String email;
    private boolean loginSuccessful;
}
