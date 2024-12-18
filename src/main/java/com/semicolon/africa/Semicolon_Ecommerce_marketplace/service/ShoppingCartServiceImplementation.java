package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.CartItem;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ShoppingCart;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.CartItemRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.ProductRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.ShoppingCartRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.CartItemRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartRemoveRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ShoppingCartUpdateRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ShoppingCartRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ShoppingCartRemoveResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ShoppingCartUpdateResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.CartItemNotFoundException;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.InvalidCartItemException;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.ProductNotFoundException;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.ShoppingCartIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.mapCartItem;
import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.mapShoppingCart;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService{

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<ShoppingCart> getAllCartItems() {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart findCartById(String cartItem_id) {
        return shoppingCartRepository.findById(cartItem_id)
                .orElseThrow( () -> new ShoppingCartIdNotFoundException("Shopping Cart ID not found"));
    }

    @Override
    public ShoppingCartRegisterResponse addItemToCart(ShoppingCartRegisterRequest shoppingCartRegisterRequest) {
        CartItem cartItem = new CartItem();
        mapCartItem(shoppingCartRegisterRequest, cartItem);
        validateCartItem(cartItem.getCartItem_id());
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartRegisterRequest.getShoppingCart_id())
                        .orElseThrow( () -> new ShoppingCartIdNotFoundException("Shopping Cart ID not Found"));
        shoppingCart.getItems().add(cartItem);
        ShoppingCart shoppingCartSavedItem = shoppingCartRepository.save(shoppingCart);
        return mapShoppingCart(shoppingCartSavedItem);
    }

    @Override
    public ShoppingCartRemoveResponse removeItemFromCart(ShoppingCartRemoveRequest shoppingCartRemoveRequest) {
        return null;
    }

    private void validateCartItem(String cartItem_id) {
        Optional<CartItem> validateItem = cartItemRepository.findById(cartItem_id);
        if (validateItem.isEmpty()) {
            throw new CartItemNotFoundException("Cart Item Not Found with this ID: " + cartItem_id);
        }
        CartItem cartItem = validateItem.get();
        if (cartItem.getQuantityOfProducts() <= 0) {
            throw new InvalidCartItemException("Invalid Quantity of Cart Item ID: " + cartItem_id);
        }
    }

    @Override
    public ShoppingCartRemoveResponse removeItemFromCart(String cartItem_id, String product_id) {
        ShoppingCart cart = shoppingCartRepository.findById(cartItem_id)
                .orElseThrow( () -> new ShoppingCartIdNotFoundException("Shopping Cart ID not found"));
        Product product = productRepository.findById(product_id)
                .orElseThrow( () -> new ProductNotFoundException("Product does not exist"));
        cart.getItems().removeIf(item -> item.getProduct_id().equals(product_id));
        shoppingCartRepository.save(cart);
        ShoppingCartRemoveResponse removeResponse =new ShoppingCartRemoveResponse();
        removeResponse.setMessage("Item was Successfully Removed");
        return removeResponse;
    }

    @Override
    public ShoppingCartUpdateResponse updateItemInCart(ShoppingCartUpdateRequest shoppingCartUpdateRequest) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartUpdateRequest.getShoppingCart_id())
                .orElseThrow( () -> new ShoppingCartIdNotFoundException("Shopping Cart Not Found"));
        CartItem cartItem = shoppingCart.getItems().stream().filter(item -> item.getCartItem_id()
             .equals(shoppingCartUpdateRequest.getCardItem_id())).findFirst()
             .orElseThrow( () -> new CartItemNotFoundException("Cart Item ID Not Found"));
        cartItem.setCartItem_id(shoppingCart.);
    }

    @Override
    public List<ShoppingCart> getAllShoppingCartItems() {
        return shoppingCartRepository.findAll();
    }

}
