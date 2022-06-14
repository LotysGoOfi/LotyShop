package by.itacademy.lotys.web.shop.lotyshop.anatations;

import java.lang.reflect.Field;
import java.util.Arrays;


public class NumberValidate {

    public static boolean validate(Object object) {
        if (object == null) {
            return false;
        } else {
            Field[] declaredFields = object.getClass().getDeclaredFields();
            return Arrays.stream(declaredFields).
                    filter((field) -> field.getAnnotation(NumberToString.class) != null)
                    .noneMatch((field) -> isMore(object, field));
        }
    }

    private static boolean isMore(Object object, Field field) {
        try {
            boolean b = field.canAccess(object);
            field.setAccessible(true);
            NumberToString annotation = field.getAnnotation(NumberToString.class);
            String s = (String)field.get(object);
            field.setAccessible(b);
            return annotation.number() > s.length();
        } catch (IllegalAccessException e) {
            return false;
        }
    }

}
