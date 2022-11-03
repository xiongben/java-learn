package com.xb;

public class Test {
    public static void main(String[] args) {

        // static变量
        System.out.println(Student.onLineNumber);
        Student.onLineNumber += 1;
        System.out.println(Student.onLineNumber);

        // static function
        System.out.println(Student.getMax(55, 88));

        Student s = new Student();
        s.setName("zhang");
        s.setAge(22);
        s.setSex('男');


    }
}
