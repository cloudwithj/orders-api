package com.cloudwithj.orders.domain;

import java.util.UUID;

public record OrderId(String value) {

    public OrderId {
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("OrderId cannot be null or blank");
        }
    }

    public static OrderId generate() {
        return new OrderId(UUID.randomUUID().toString());
    }
}
