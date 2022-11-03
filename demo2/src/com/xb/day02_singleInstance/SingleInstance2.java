package com.xb.day02_singleInstance;

public class SingleInstance2 {
    public static SingleInstance2 instance2;

    private SingleInstance2() {

    }

    public static SingleInstance2 getInstance() {
        if(instance2 == null) {
            instance2 = new SingleInstance2();
        }
        return instance2;
    }
}
