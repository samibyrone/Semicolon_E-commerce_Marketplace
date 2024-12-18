package com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.CartItem;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ShoppingCart;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.User;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.*;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.*;

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
        productRegisterResponse.setMessage("Product Was Successfully Created");
        productRegisterResponse.setProduct_id(product.getProduct_id());
        return productRegisterResponse;
    }

    public static void mapProductUpdate(ProductUpdatesRequest productUpdatesRequest, Product product) {
        product.setProductName(productUpdatesRequest.getProductName());
        product.setProductDescription(productUpdatesRequest.getProductDescription());
        product.setProductPrice(productUpdatesRequest.getProductPrice());
        product.setProductStock(productUpdatesRequest.getProductStock());
        product.setProductCategory(productUpdatesRequest.getProductCategory());
    }

    public static ProductUpdateResponse mapProductUpdate( Product product) {
        ProductUpdateResponse productUpdateResponse = new ProductUpdateResponse();
        productUpdateResponse.setMessage("Product Was Successfully Updated");
        productUpdateResponse.setProduct_id(product.getProduct_id());
        return productUpdateResponse;
    }

    public static void mapShoppingCart(ShoppingCartRegisterRequest shoppingCartRegisterRequest, ShoppingCart shoppingCart) {
        shoppingCart.setItems(shoppingCartRegisterRequest.getItems());
        shoppingCart.setTotalPrice(shoppingCartRegisterRequest.getTotalPrice());
    }

    public static ShoppingCartRegisterResponse mapShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCartRegisterResponse shoppingCartRegisterResponse = new ShoppingCartRegisterResponse();
        shoppingCartRegisterResponse.setMessage("ShoppingCart Was Successfully Created");
        shoppingCartRegisterResponse.setShoppingCart_id(shoppingCart.getShoppingCart_id());
        return shoppingCartRegisterResponse;
    }

    public static void mapCartItem(CartItemRegisterRequest cartItemRegisterRequest, CartItem cartItem) {
        cartItem.setProductName(cartItem.getProductName());
        cartItem.setPrice(cartItemRegisterRequest.getPrice());
        cartItem.setQuantityOfProducts(cartItemRegisterRequest.getQuantityOfProducts());
        cartItem.setProductcategory(cartItemRegisterRequest.getProductcategory());
    }

    public static CartItemRegisterResponse mapCartItem(CartItem cartItem) {
        CartItemRegisterResponse cartItemRResponse = new CartItemRegisterResponse();
        cartItemRResponse.setMessage("CartItem Was Successfully Created");
        cartItemRResponse.setCartItem_id(cartItem.getCartItem_id());
        return cartItemRResponse;
    }


}
