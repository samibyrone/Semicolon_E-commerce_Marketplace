package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.ProductRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.map;
import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.mapProduct;


@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String product_id) {
        return productRepository.findById(product_id)
                .orElseThrow( () -> new ProductNotFoundException("Product does not exist"));
    }

    @Override
    public ProductRegisterResponse addProduct(ProductRegisterRequest productRegisterRequest) {
        Product product = new Product();
        mapProduct(productRegisterRequest, product);
        Product newProduct = productRepository.save(product);
        return mapProduct(newProduct);
    }

    public ProductRegisterResponse updateProduct(String product_id, Product productDetails) {
        Product product = productRepository.findById(product_id)
                .orElseThrow( () -> new ProductNotFoundException("Product does not exist"));
        product.setProductName(productDetails.getProductName());
        product.setProductDescription(productDetails.getProductDescription());
        product.setProductPrice(productDetails.getProductPrice());
        product.setProductStock(productDetails.getProductStock());
        productRepository.save(product);
        ProductRegisterResponse response = new ProductRegisterResponse();
        response.setMessage("Product successfully updated");
        return response;
    }

    public void deleteProduct(String product_id) {
        productRepository.deleteById(product_id);
    }

}
