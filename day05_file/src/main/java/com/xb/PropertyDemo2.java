package com.xb;

import java.io.FileReader;
import java.util.Properties;

public class PropertyDemo2{
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("/Users/admin/Desktop/users.properties"));
        System.out.println(properties);
        String rs = properties.getProperty("hei");
        System.out.println(rs);
    }
}
