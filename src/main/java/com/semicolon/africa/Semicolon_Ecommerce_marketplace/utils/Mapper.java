package com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.User;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserLoginResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.UserRegisterResponse;

public class Mapper {

    public static void map(UserRegisterRequest userRegisterRequest, User user) {
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setUserName(userRegisterRequest.getUserName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setAddress(userRegisterRequest.getAddress());
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
        user.setPassword(userRegisterRequest.getPassword());
        user.setRole(userRegisterRequest.getRole());
    }

    public static UserRegisterResponse map(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setMessage("Registered Successfully");
        user.setEmail(user.getEmail());
        return userRegisterResponse;
    }

    public static UserLoginResponse mapLogin(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userLoginResponse.setMessage("Logged in Successfully");
        userLoginResponse.setLoginSuccessful(true);
        return userLoginResponse;
    }

    public static UserLoginResponse mapLogout(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userLoginResponse.setMessage("Logged out Successfully");
        userLoginResponse.setLoginSuccessful(false);
        return userLoginResponse;
    }

    public static void mapProduct(ProductRegisterRequest productRegisterRequest, Product product) {
        product.setProductName(productRegisterRequest.getProductName());
        product.setProductDescription(productRegisterRequest.getProductDescription());
        product.setProductPrice(productRegisterRequest.getProductPrice());
        product.setProductStock(productRegisterRequest.getProductStock());
        product.setProductCategory(productRegisterRequest.getProductCategory());
        }

    public static ProductRegisterResponse mapProduct(Product product) {
        ProductRegisterResponse productRegisterResponse = new ProductRegisterResponse();
        productRegisterResponse.setMessage("Product Successfully Created");
        productRegisterResponse.setProduct_id(product.getId());
        return productRegisterResponse;
    }
}
