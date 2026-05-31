package com.code;

import com.code.tasks.threads.BlockingQueue;
import com.code.tasks.threads.Consumer;
import com.code.tasks.threads.Producer;


public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new BlockingQueue<>(15);
        Thread adder = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue), "cons1");
        Thread consumer2 = new Thread(new Consumer(queue), "cons2");

        consumer2.start();
        consumer.start();
        adder.start();
    }
}