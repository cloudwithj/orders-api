package com.cloudwithj.orders.infrastructure.client.model;

import java.math.BigDecimal;

public record PaymentPayload(String orderId, BigDecimal amount) {
}