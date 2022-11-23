package com.xb.demo2;


import java.lang.annotation.Annotation;

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        Class c5 = BookStore.class;
        if(c5.isAnnotationPresent(MyBook.class)) {
            System.out.println("=====");
            MyBook book = (MyBook) c5.getDeclaredAnnotation(MyBook.class);
            System.out.println(book.name());
            System.out.println(book.price());
            System.out.println(book.authors());
        }

    }
}

@MyBook(name = "<坦克世界>", authors = {"hhhh","aaa"}, price = 100.0)
class BookStore{
    @MyBook(name = "<战机世界>", authors = {"hhhh","aaa"}, price = 150.0)
    public void test() {

    }
}