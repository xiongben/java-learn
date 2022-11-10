package com.xb;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommonsIoDemo {
    public static void main(String[] args) throws IOException {
        IOUtils.copy(new FileInputStream("/Users/admin/Desktop/aa2.txt"), new FileOutputStream("/Users/admin/Desktop/aa5.txt"));

    }
}
