package com.cloudwithj.orders.infrastructure.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoOrderRepository extends MongoRepository<OrderDocument, String> {
    OrderDocument findByOrderId(String orderId);
}
