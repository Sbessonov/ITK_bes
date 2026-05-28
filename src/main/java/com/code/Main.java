package com.code;


import com.code.tasks.elementcalcualtion.ElementCalculator;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] arr = {"1", "2", "3", "2", "1", "1", "5"};
        Map<String, Long> result = ElementCalculator.getCountByElement(arr);
        result.entrySet().forEach(System.out::println);
    }
}