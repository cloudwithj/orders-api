package com.cloudwithj.orders.infrastructure.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class OrderDocument {

    @Id
    private String id;
    private String orderId;
    private BigDecimal amount;

    public OrderDocument(String orderId, BigDecimal amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
}
