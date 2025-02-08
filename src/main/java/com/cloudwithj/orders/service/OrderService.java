package com.cloudwithj.orders.service;

import com.cloudwithj.orders.api.model.OrderPayload;
import com.cloudwithj.orders.domain.Order;
import com.cloudwithj.orders.domain.OrderId;
import com.cloudwithj.orders.infrastructure.client.PaymentClient;
import com.cloudwithj.orders.infrastructure.client.model.PaymentPayload;
import com.cloudwithj.orders.infrastructure.db.MongoOrderRepository;
import com.cloudwithj.orders.infrastructure.db.OrderDocument;
import com.cloudwithj.orders.infrastructure.db.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final PaymentClient paymentClient;
    private final OrderMapper orderMapper;
    private final MongoOrderRepository mongoOrderRepository;

    public String processOrder(OrderPayload orderPayload) {
        OrderId newId = OrderId.generate();
        PaymentPayload paymentPayload = new PaymentPayload(newId.value(), orderPayload.amount());
        String paymentResponse = paymentClient.processPayment(paymentPayload);

        Order order = new Order(newId, orderPayload.amount());
        OrderDocument document = orderMapper.toDocument(order);
        OrderDocument savedDocument = mongoOrderRepository.save(document);

        return "Payment: " + paymentResponse + "; Order saved with ID: " + savedDocument.getOrderId();
    }
}
