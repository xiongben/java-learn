package com.xb.demo1;

public class Student {
    private String name;
    private int age;
    public static String schoolName;
    public static final String Country = "ssssss";

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        System.out.println("误餐构造器执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        System.out.println("在执行getAge方法！");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
