package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
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

    }
}