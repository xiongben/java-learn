package com.xb;

public class ThreadDemo {
    public static void main(String[] args) {
       Runnable target = new MyRunnable();
       Thread t = new Thread(target);
       t.start();
        for(int i = 0; i < 5; i++) {
            System.out.println("主线程执行输出：" + i);
        }

    }
}

/**
 * 方式一
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("子线程执行输出：" + i);
        }
    }
}

/**
 *  方式二：扩展性比较强，但是多了一层包装
 */
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "输出：" + i);
        }
    }
}