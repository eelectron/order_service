package com.example.order_service.service;

import com.example.order_service.common.Payment;
import com.example.order_service.common.TransactionRequest;
import com.example.order_service.common.TransactionResponse;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

@Service
public class OrderService {
    @Inject
    private OrderRepository orderRepository;

    @Inject
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest orderReq){
        Order order = orderReq.getOrder();
        Payment payment = orderReq.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        // rest call to make payment for the order
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT_SERVICE/payments", payment, Payment.class);
        String orderMessage = paymentResponse.getStatus().equalsIgnoreCase("success") ? "order placed" : "order added to cart due to a failure";
        TransactionResponse transactionResponse = new TransactionResponse(order, paymentResponse.getTransactionId(), order.getPrice(), orderMessage);
        orderRepository.save(order);
        return transactionResponse;
    }
}
