package com.xb.day01_log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {
    // 日志练习
    public static final Logger LOGGER = LoggerFactory.getLogger("Test1.class");
    public static void main(String[] args) {
      try {
          LOGGER.debug("main function running,,,,,");
          LOGGER.info("我开始记录第二行日志");
          int a = 10;
          int b = 0;
          LOGGER.trace("a=", a);
          LOGGER.trace("b=",b);
          System.out.println(a / b);
      } catch (Exception e) {
          e.printStackTrace();
          LOGGER.error("function error == : " + e);
      }
    }
}
