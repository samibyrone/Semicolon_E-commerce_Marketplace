package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRegisterResponse;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String product_id);

    void deleteProduct(String product_id);

    ProductRegisterResponse addProduct(ProductRegisterRequest productRegisterRequest);

    ProductRegisterResponse updateProduct(String product_id, Product productDetails);

}
