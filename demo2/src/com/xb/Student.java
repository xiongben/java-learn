package com.xb;

public class Student {
    public static String onLineNumber = "666";
    private String name;
    private int age;
    public char sex;

    static {
        System.out.println("静态代码块执行========");
        onLineNumber = "88889999";
    }

    public Student() {
    }

    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static int getMax(int age1, int age2) {
        return age1 > age2 ? age1 : age2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }



}
