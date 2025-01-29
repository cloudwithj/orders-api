package com.cloudwithj.orders.service;

import com.cloudwithj.orders.api.model.OrderPayload;
import com.cloudwithj.orders.infrastructure.client.PaymentClient;
import com.cloudwithj.orders.infrastructure.client.model.PaymentPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PaymentClient paymentClient;

    public String processOrder(OrderPayload orderPayload) {
        PaymentPayload paymentPayload = new PaymentPayload(orderPayload.orderId(), orderPayload.amount());
        return paymentClient.processPayment(paymentPayload);
    }
}
