package org.example.concurency.blockingQ;

import java.util.ArrayDeque;

public class MyBlockingQueue<T> {

    private final Integer MAX_SIZE_QUEUE = 10;
    private ArrayDeque<T> queue;
    private final Object lock = new Object();

    MyBlockingQueue() {
        this.queue = new ArrayDeque<>(MAX_SIZE_QUEUE);
    }

    public void enqueue(T o) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == MAX_SIZE_QUEUE) {
                lock.wait();
            }
            this.queue.offer(o);
            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (lock) {
            while (queue.isEmpty()) {
                lock.wait();
            }
            T t =  queue.poll();
            lock.notifyAll();
            return t;
        }
    }

    public int size() {
        synchronized (lock) {
            return queue.size();
        }
    }
}
