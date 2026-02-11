package org.example.concurency.sinhronized;

public class ComplexTask  {
    public Runnable execute() {
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
         return runnable;
    }
}
