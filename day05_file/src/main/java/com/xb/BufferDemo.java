package com.xb;

import java.io.*;

public class BufferDemo {
    public static void main(String[] args) {
        try(
                Reader fr = new FileReader("/Users/admin/Desktop/aa.txt");
                BufferedReader br = new BufferedReader(fr);
                Writer fw = new FileWriter("/Users/admin/Desktop/aa3.txt");
                BufferedWriter bw = new BufferedWriter(fw);
         ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
