package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRemoveRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductUpdatesRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRemoveResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String product_id);

    ProductRemoveResponse deleteProduct(String product_id);

    ProductRegisterResponse addProduct(ProductRegisterRequest productRegisterRequest);

    ProductRegisterResponse updateProduct(String product_id, ProductUpdatesRequest productUpdatesRequest);

}
