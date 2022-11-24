package com.xb.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarAgentProxy {

    public static Skill getProxy(Star s) {
        return (Skill) Proxy.newProxyInstance(s.getClass().getClassLoader(), s.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("收首付款！，，，代理");
                Object rs = method.invoke(s, objects);
                System.out.println("收尾款");
                return rs;
            }
        });
    }
}
