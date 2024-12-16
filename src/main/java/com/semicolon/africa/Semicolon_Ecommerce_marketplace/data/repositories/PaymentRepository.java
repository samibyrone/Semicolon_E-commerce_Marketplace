package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.repositories;

import com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {

}
