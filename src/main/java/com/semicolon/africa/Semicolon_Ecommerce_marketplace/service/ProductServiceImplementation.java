package com.semicolon.africa.Semicolon_Ecommerce_marketplace.service;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Product;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.User;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.UserType;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductUpdatesRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRemoveResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories.ProductRepository;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.requests.ProductRegisterRequest;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses.ProductRegisterResponse;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.ProductNotFoundException;
import com.semicolon.africa.Semicolon_Ecommerce_marketplace.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.map;
import static com.semicolon.africa.Semicolon_Ecommerce_marketplace.utils.Mapper.mapProduct;


@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

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
        User user = new User();
        validateUser(user.getId());
        Product product = new Product();
        mapProduct(productRegisterRequest, product);
        Product newProduct = productRepository.save(product);
        return mapProduct(newProduct);
    }

    private void validateUser(String user_id) {
        Optional<User> userValidation = userService.findUserById(user_id);
        if (userValidation.isPresent()) { User user = userValidation.get();
            if (user.getUserType() == UserType.SELLER) { productRepository.save(new Product()); }
        }else { throw new UserNotFoundException("User does not exist"); }
    }

    public ProductRegisterResponse updateProduct(String product_id, ProductUpdatesRequest productUpdatesRequest) {
        Product product = productRepository.findById(product_id)
                .orElseThrow( () -> new ProductNotFoundException("Product does not exist"));
        product.setProductName(productUpdatesRequest.getProductName());
        product.setProductDescription(productUpdatesRequest.getProductDescription());
        product.setProductPrice(productUpdatesRequest.getProductPrice());
        product.setProductStock(productUpdatesRequest.getProductStock());
        productRepository.save(product);
        ProductRegisterResponse response = new ProductRegisterResponse();
        response.setMessage("Product successfully updated");
        return response;
    }

    public ProductRemoveResponse deleteProduct(String product_id) {
        Product product = productRepository.findById(product_id)
            .orElseThrow( () -> new ProductNotFoundException("Product does not exist"));
        product.setProduct_id(product_id);
        productRepository.deleteById(product_id);
        ProductRemoveResponse response = new ProductRemoveResponse();
        response.setMessage("Product Successfully Deleted");
        return response;

    }

}
