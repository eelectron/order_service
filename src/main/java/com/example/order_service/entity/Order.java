package com.example.order_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Integer id;
    private String name;
    private Integer qty;
    private Double price;
}
