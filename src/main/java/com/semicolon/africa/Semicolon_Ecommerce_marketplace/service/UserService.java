package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.User;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.UserLoginRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserLoginResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserRegisterResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest);

    List<User> getAllUsers();

    Optional<User> findUserById(String userId);

    UserLoginResponse loginUser(UserLoginRequest userLogin);

    UserLoginResponse loggedOut(UserLoginRequest userLoggedOut);
}
