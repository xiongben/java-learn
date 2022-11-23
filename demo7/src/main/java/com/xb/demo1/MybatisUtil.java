package com.xb.demo1;

import java.lang.reflect.Field;

public class MybatisUtil {
    /**
     * 保存任意类型的对象
     * @param obj
     */
    public static void save(Object obj) {
        try {
            Class c = obj.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                field.setAccessible(true);
                String value = field.get(obj) + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
