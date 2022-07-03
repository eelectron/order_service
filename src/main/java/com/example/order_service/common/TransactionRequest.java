package com.example.order_service.common;

import com.example.order_service.entity.Order;
import lombok.Data;

@Data
public class TransactionRequest {
    private Order order;
    private Payment payment;
}
