package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.ProductCategory;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.ProductRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRemoveRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductUpdatesRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRemoveResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductUpdateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class ProductServiceImplementationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImplementation productServiceImplementation;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    public void testThatProductCanBeAddedToRepository() {
        ProductRegisterResponse productResponse = ProductRegister();
        assertThat(productResponse).isNotNull();
        assertThat(productResponse.getMessage().contains("Product added successfully"));
    }

    private ProductRegisterResponse ProductRegister() {
        ProductRegisterRequest productRequest = new ProductRegisterRequest();
        productRequest.setProduct_id("225");
        productRequest.setProductName("Bread");
        productRequest.setProductDescription("Sliced-Bread");
        productRequest.setProductPrice(1500.0);
        productRequest.setProductStock(2);
        productRequest.setProductCategory(ProductCategory.SUPERMARKET);
        ProductRegisterResponse productResponse = productServiceImplementation.addProduct(productRequest);
        return productResponse;
    }

    @Test
    public void testThatProductCanBeRemovedFromRepository() {
        ProductRegister();
        ProductRemoveRequest removeRequest = new ProductRemoveRequest();
        removeRequest.setProductId("225");
        removeRequest.setProductName("Bread");
        removeRequest.setProductDescription("Sliced-Bread");
        removeRequest.setProductPrice(1500.0);
        removeRequest.setProductStock(1);
        removeRequest.setProductCategory(ProductCategory.SUPERMARKET);
        ProductRemoveResponse removeResponse = productServiceImplementation.deleteProduct("225");
        assertThat(removeResponse.getMessage()).contains("Product removed successfully");
    }

    @Test
    public void testThatProductCanBeUpdatedInTheRepository() {
        ProductRegister();
        ProductUpdatesRequest productUpdates = new ProductUpdatesRequest();
        productUpdates.setProductId("297");
        productUpdates.setProductName("Television-set");
        productUpdates.setProductDescription("LCD Television-set");
        productUpdates.setProductPrice(157000.0);
        productUpdates.setProductStock(20);
        productUpdates.setProductCategory(ProductCategory.ELECTRONICS);
        ProductRegisterResponse updateResponse = productServiceImplementation.updateProduct("297", productUpdates);
        assertThat(updateResponse.getMessage()).contains("Product updated successfully");
    }

}