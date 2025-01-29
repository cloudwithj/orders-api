package com.cloudwithj.orders.infrastructure.client;

import com.cloudwithj.orders.infrastructure.client.model.PaymentPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "${payment-service.url}")
public interface PaymentClient {

    @PostMapping("/api/v1/payments")
    String processPayment(@RequestBody PaymentPayload paymentPayload);
}