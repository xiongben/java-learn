package com.xb.demo3;

public class Test {
    public static void main(String[] args) {
        Star s = new Star("刘德华");
        Skill s2 = StarAgentProxy.getProxy(s);
        s2.jump();
//        s2.sing();


    }
}
