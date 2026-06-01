package com.code.tasks.threads.aggregator;

import java.util.Random;
import java.util.concurrent.CompletableFuture;


public class DataAggregator {

    public ProductInfo aggregateProductInfo(String productName) {
        CompletableFuture<String> description = CompletableFuture
                .supplyAsync(this::getDescription)
                .exceptionally(
                        ex -> "Нет данных"
                );

        CompletableFuture<Double> rating = CompletableFuture
                .supplyAsync(this::getRating)
                .exceptionally(ex -> 0.0);

        CompletableFuture<Double> price = CompletableFuture
                .supplyAsync(this::getPrice)
                .exceptionally(ex -> 0.0);

        return CompletableFuture.allOf(description, rating, price).thenApply(
                (ignored) -> new ProductInfo(productName, description.join(), price.join(), rating.join())
        ).join();

    }

    private void sleepAndThrow() {
        Random rnd = new Random();
        long millis = rnd.nextLong(1000, 3000);
        int probability = rnd.nextInt(1, 100);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (probability <= 20)
            throw new RuntimeException();
    }

    private String getDescription() {
        sleepAndThrow();
        return "Описание";
    }

    private double getPrice() {
        sleepAndThrow();
        return 100.5;
    }

    private double getRating() {
        sleepAndThrow();
        return 50.0;
    }

}
