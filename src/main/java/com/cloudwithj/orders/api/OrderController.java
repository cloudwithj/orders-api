package com.cloudwithj.orders.api;

import com.cloudwithj.orders.api.model.OrderPayload;
import com.cloudwithj.orders.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Process an order", description = "Creates an order and processes the payment")
    public ResponseEntity<String> processOrder(@RequestBody OrderPayload orderPayload) {
        String paymentResponse = orderService.processOrder(orderPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentResponse);
    }
}
