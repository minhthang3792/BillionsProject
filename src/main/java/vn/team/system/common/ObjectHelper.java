package vn.team.system.common;

import vn.team.system.common.annotation.CanNullOrEmpty;

import java.lang.reflect.Field;
import java.util.Objects;

public class ObjectHelper {

    public static void printObject(Object object) {
        Objects.requireNonNull(object, "Object is null");
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);

                if (f.isAnnotationPresent(CanNullOrEmpty.class)) {
                    continue;
                }

                if (f.get(object) == null) {
                    throw new NullPointerException((f.getName() + " property is null"));
                }

                if (String.valueOf(f.get(object)).isEmpty()) {
                    throw new NullPointerException((f.getName() + " property is empty"));
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.printf("Get exception");
        }
    }

}

