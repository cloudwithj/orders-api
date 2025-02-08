package com.cloudwithj.orders.infrastructure.db;

import com.cloudwithj.orders.domain.Order;
import com.cloudwithj.orders.domain.OrderId;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDocument toDocument(Order order) {
        return new OrderDocument(order.getOrderId().value(), order.getAmount());
    }

    public Order toDomain(OrderDocument document) {
        return new Order(new OrderId(document.getOrderId()), document.getAmount());
    }
}
