package com.xb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDemo2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Runnable target = new MyRunnable();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
    }
}
