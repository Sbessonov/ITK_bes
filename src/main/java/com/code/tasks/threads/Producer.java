package com.code.tasks.threads;

public class Producer implements Runnable {
    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> commonResource) {
        this.queue = commonResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(String.valueOf(i));
        }
    }
}