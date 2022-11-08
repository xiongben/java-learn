package com.xb;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo1 {
    public static void main(String[] args) {
        File f = new File("/Users/admin/Desktop/aa.png");
        long size = f.length();
        System.out.println(size);
        long time = f.lastModified();
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time));
        System.out.println(f.isDirectory());
    }
}
