package com.cloudwithj.orders.api.model;

import java.math.BigDecimal;

public record OrderPayload(String orderId, BigDecimal amount) {
}