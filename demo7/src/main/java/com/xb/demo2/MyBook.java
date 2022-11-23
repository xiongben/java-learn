package com.xb.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
public @interface MyBook {
    String name();
    String[] authors();
    double price();
}
