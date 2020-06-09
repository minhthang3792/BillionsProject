package vn.team.system.common.validation;

import java.lang.reflect.Field;
import java.util.Objects;
import vn.team.system.common.annotation.CanNullOrEmpty;

public class Validation {

  public void checkCanNullOrEmpty(Object object) {
    Objects.requireNonNull(object, "Object is null");
    try {
      Field[] fields = object.getClass().getDeclaredFields();
      for (Field f : fields) {
        f.setAccessible(true);

        if (f.isAnnotationPresent(CanNullOrEmpty.class)) {
          continue;
        }

        if (f.get(object) == null) {
          throw new NullPointerException(("Properties " + f.getName() + " is null"));
        }

        if (String.valueOf(f.get(object)).isEmpty()) {
          throw new NullPointerException(("Properties " + f.getName() + " is empty"));
        }
      }
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.printf("Get exception");
    }
  }

}

