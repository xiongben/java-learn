package com.xb;

import java.io.FileWriter;
import java.util.Properties;

public class PropertyDemo {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("amin", "123456");
        properties.setProperty("deli","123");
        properties.setProperty("hei","2222");
        System.out.println(properties);

        properties.store(new FileWriter("/Users/admin/Desktop/users.properties"), "this is a user!");
    }
}
