package com.example.order_service.controller;

import com.example.order_service.common.Payment;
import com.example.order_service.common.TransactionRequest;
import com.example.order_service.common.TransactionResponse;
import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class OrderController {

    @Inject
    private OrderService orderService;

    @PostMapping("/orders")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest orderReq){


        return orderService.saveOrder(orderReq);

        // do a rest call to payment api and pass the orderId
    }
}