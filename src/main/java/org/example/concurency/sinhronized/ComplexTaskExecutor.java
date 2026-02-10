package org.example.concurency.sinhronized;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {
    private CyclicBarrier barrier;


    public ComplexTaskExecutor(int taskCount) {
        this.barrier = new CyclicBarrier(taskCount);
    }

    public void executeTasks(int taskCount) {
        ExecutorService executor = Executors.newFixedThreadPool(taskCount);

        for (int i = 0; i < taskCount; i++) {
            executor.submit(new ComplexTask().execute());
        }
        try {
            int count = barrier.await();
            System.out.println("task = " + count + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
