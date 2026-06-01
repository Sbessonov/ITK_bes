package com.code;


import com.code.stream.generation.Order;
import com.code.stream.generation.ProductProcessing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Lamp", 500.0),
                new Order("Chair", 1400.0),
                new Order("Smartphone", 900.0)
        );

        List<Order> top3 = ProductProcessing.getTop3MaxCostProduct(orders);

        top3.forEach(System.out::println);
    }
}