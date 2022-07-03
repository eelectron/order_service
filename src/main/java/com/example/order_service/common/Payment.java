package com.example.order_service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    private String status;
    private String transactionId;

    // order service will set this value
    private Integer orderId;

    // order service will set this value
    private Double amount;
}
