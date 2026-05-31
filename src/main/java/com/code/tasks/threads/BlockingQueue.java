package com.code.tasks.threads;

import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingQueue<T> {
    private final Queue<T> queue = new ArrayDeque<>();
    private final long capacity;

    public BlockingQueue(long capacity){
        this.capacity = capacity;
    }
    public synchronized void enqueue(T element) {
        while (capacity == queue.size()) {
            try {
                // не добавляем, пока очередь полна
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(element);
        notify();
    }

    public synchronized T dequeue() {
        while (queue.isEmpty()) {
            try {
                // ждем пока очередь пуста
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        T element = queue.poll();
        notify();
        return element;
    }

    public synchronized int size(){
        return queue.size();
    }
}
