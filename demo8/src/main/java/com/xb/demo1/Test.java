package com.xb.demo1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * xml解析demo
 */
public class Test {
    public static void main(String[] args) throws IOException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("/Users/admin/learnArea/java-learn/demo8/src/main/resources/hello.xml"));
        Element root = document.getRootElement();
        System.out.println(root.getName());
    }
}
