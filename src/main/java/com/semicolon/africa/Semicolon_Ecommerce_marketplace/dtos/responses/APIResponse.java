package com.semicolon.africa.Semicolon_Ecommerce_marketplace.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class APIResponse {
    private boolean isSuccessful;
    private Object data;
}
