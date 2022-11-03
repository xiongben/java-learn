package com.xb.day02_singleInstance;

public class Test1 {
    public static void main(String[] args) {
        SingleInstance s1 = SingleInstance.instance;
        SingleInstance s2 = SingleInstance.instance;
        System.out.println(s1 == s2);

        SingleInstance2 s3 = SingleInstance2.getInstance();
        SingleInstance2 s4 = SingleInstance2.getInstance();
        System.out.println(s3 == s4);
    }
}
