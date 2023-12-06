package com.aisino.util;

import java.lang.reflect.Field;

/**
 *  校验对象是否为null
 */
public class CheckObjectNullUtil {

    public static boolean allFieldsNull(Object obj) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(obj) != null) {
                return false;
            }
        }
        return true;
    }
}
