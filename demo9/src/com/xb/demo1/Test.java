package com.xb.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("/Users/admin/learnArea/java-learn/demo9/src/aa.txt");
    }
}
