package org.example.stream.factorial;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 5;
    private int n;
    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if ((n == 0) || (n == 1)) return 1L;
         else {
            FactorialTask subTask = new FactorialTask(n - 1);
            subTask.fork();
            return n * subTask.join();
        }
    }
}
