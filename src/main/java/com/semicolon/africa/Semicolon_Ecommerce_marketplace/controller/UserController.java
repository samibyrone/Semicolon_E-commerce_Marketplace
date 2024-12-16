package com.semicolon.africa.Semicolon_Ecommerce_marketplace.controller;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.User;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.UserLoginRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.APIResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserLoginResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/map")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/User-sign-up")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest userRequest) {
        try{
            UserRegisterResponse userRegisterResponse = userService.registerUser(userRequest);
            return new ResponseEntity<>(new APIResponse(true, userRegisterResponse), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new APIResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/User-login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest userRequest) {
        try {
            UserLoginResponse userLoginResponse = userService.loginUser(userRequest);
            return new ResponseEntity<>(new APIResponse(true, userLoginResponse), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new APIResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }
}
