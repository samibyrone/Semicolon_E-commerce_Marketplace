package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class UserRegisterRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String role;
}
