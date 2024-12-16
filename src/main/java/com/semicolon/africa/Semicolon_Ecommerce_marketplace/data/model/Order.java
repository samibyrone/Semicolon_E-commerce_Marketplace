package com.semicolon.africa.Semicolon_Ecommerce_marketplace.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Order {

    @Id
    private int order_id;
    private int user_id;
    private Date date;
    private String status;
}
