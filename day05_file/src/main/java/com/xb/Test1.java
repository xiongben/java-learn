package com.xb;

import java.io.*;

public class Test1 {
    public static void main(String[] args) {
        try (
                InputStream is = new FileInputStream("/Users/admin/Desktop/aa.txt") ;
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream("/Users/admin/Desktop/aa2.txt");
                OutputStream bos = new BufferedOutputStream(os);
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("copy end!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
