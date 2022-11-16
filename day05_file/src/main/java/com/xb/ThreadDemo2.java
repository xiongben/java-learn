package com.xb;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Callable<String> call = new MyCallable(100);
        FutureTask<String> f1 = new FutureTask<>(call);
        Thread t1 = new Thread(f1);
        t1.start();

        Callable<String> call2 = new MyCallable(100);
        FutureTask<String> f2 = new FutureTask<>(call2);
        Thread t2 = new Thread(f2);
        t2.start();

        try {
            String res1 = f1.get();
            System.out.println("res1 is: " + res1);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            String res2 = f2.get();
            System.out.println("res2 is: " + res2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
/**
 * 定义一个任务类，实现Callable接口
 */
class MyCallable implements Callable<String>{
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            sum += i;
        }
        return "子线程的执行结果是：" + sum;
    }
}