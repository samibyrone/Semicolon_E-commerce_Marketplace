package com.semicolon.africa.Semicolon_Ecommerce_marketplace.controller;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.service.ProductService;
import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.mapProduct;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductRegisterResponse> getProductById(@PathVariable String product_id) {
        var product = productService.getProductById(product_id);
        ProductRegisterResponse  response = mapProduct(product);
        return ResponseEntity.status(OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ProductRegisterResponse> createProduct(@RequestBody ProductRegisterRequest product) {
        ProductRegisterResponse newProduct = productService.addProduct(product);
        return ResponseEntity.status(OK).body(newProduct);
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<ProductRegisterResponse> updateProduct(@PathVariable String product_id, @RequestBody ProductRegisterResponse productDetails) {
        var product = productService.getProductById(productDetails.getProduct_id());
        ProductRegisterResponse updateProduct = productService.updateProduct("1", product);
        return ResponseEntity.status(OK).body(updateProduct);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String product_id) {
        productService.deleteProduct(product_id);
        return ResponseEntity.noContent().build();
    }

}
