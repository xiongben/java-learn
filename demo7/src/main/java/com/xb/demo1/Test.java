package com.xb.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws Exception {
//        Class c = Class.forName("com.xb.demo1.Student");
//        System.out.println(c);
//
//        Class c1 = Student.class;
//        System.out.println(c1);
//
//        Student s1 = new Student();
//        Class c2 = s1.getClass();
//        System.out.println(c2);

        Class c = Student.class;
        Field ageF = c.getDeclaredField("age");
        ageF.setAccessible(true);
        // 赋值
        Student s = new Student();
        ageF.set(s, 18);
        System.out.println(s);

        //获取方法对象
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " " + method.getReturnType() + "参数个数：" + method.getParameterCount());
        }

        Method m1 = c.getMethod("getAge");
//        m1.setAccessible(true);
        m1.invoke(s);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        Class c3 = list3.getClass();
        Method add = c3.getDeclaredMethod("add", Object.class);
        boolean rs = (boolean) add.invoke(list3, "坦克世界");
        System.out.println(rs);
        System.out.println(list3);

    }
}
