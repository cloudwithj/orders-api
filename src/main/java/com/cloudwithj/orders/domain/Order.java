package com.cloudwithj.orders.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class Order {

    private final OrderId orderId;
    private final BigDecimal amount;
}
