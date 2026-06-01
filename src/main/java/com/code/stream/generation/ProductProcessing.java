package com.code.stream.generation;


import java.util.List;
import java.util.Map;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class ProductProcessing {

    public static List<Order> getTop3MaxCostProduct(List<Order> orderList) {

        return orderList.stream()
                .collect(
                        groupingBy(Order::product, summingDouble(Order::cost))
                )
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .limit(3)
                .map(entry -> new Order(entry.getKey(), entry.getValue()))
                .toList();

    }

}
