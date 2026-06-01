package com.code;

import com.code.tasks.threads.aggregator.DataAggregator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DataAggregator dataAggregator = new DataAggregator();
        for (int i = 0; i < 3; i++) {
            System.out.println(dataAggregator.aggregateProductInfo("Ноутбук"));
        }
    }
}