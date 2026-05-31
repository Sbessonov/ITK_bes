package com.code.tasks.threads.queue;


public class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> commonResource) {
        this.queue = commonResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s, get %s\n", Thread.currentThread().getName(), queue.dequeue());
        }
    }
}